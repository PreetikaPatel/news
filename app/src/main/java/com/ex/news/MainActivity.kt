package com.ex.news

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex.news.Models.NewsApiResponse
import com.ex.news.Models.NewsHeadlines
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SelectListener, View.OnClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CustomAdapter
    lateinit var dailog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                dailog!!.setTitle("Fetching news articles of $query")
                dailog!!.show()
                val manager = RequestManager(this@MainActivity)
                manager.getNewsHeadlines(listener, "general", query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        dailog = ProgressDialog(this)
        dailog!!.setTitle("Fetching news Articles")
        dailog!!.show()

        btn_business.setOnClickListener(this)

        btn_entertainment.setOnClickListener(this)

        btn_general.setOnClickListener(this)

        btn_health.setOnClickListener(this)

        btn_science.setOnClickListener(this)

        btn_sports.setOnClickListener(this)

        btn_technology.setOnClickListener(this)

        val manager = RequestManager(this)
        manager.getNewsHeadlines(listener, "general", null)
    }

    private val listener: OnFetchDataListener<NewsApiResponse> = object : OnFetchDataListener<NewsApiResponse> {
        override fun OnFetchData(list: List<NewsHeadlines>?, message: String?) {
            if (list?.isEmpty() == true) {
                Toast.makeText(this@MainActivity, "No data found!!!", Toast.LENGTH_SHORT).show()
            } else {
                list?.let { showNews(it) }
                dailog!!.dismiss()
            }
        }

        override fun OnError(message: String?) {
            Toast.makeText(this@MainActivity, "An Error Occured!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showNews(list: List<NewsHeadlines>) {
        recyclerView = findViewById(R.id.recycler_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        adapter = CustomAdapter(this, list, this)
        recyclerView.setAdapter(adapter)
    }

    override fun OnNewsClicked(headlines: NewsHeadlines?) {
        startActivity(Intent(this@MainActivity, DetailsActivity::class.java).putExtra("data", headlines))
    }

    override fun onClick(view: View) {
        val button = view as Button
        val category = button.text.toString()
        dailog!!.setTitle("Fetching news article of $category")
        dailog!!.show()
        val manager = RequestManager(this)
        manager.getNewsHeadlines(listener, category, null)
    }


}