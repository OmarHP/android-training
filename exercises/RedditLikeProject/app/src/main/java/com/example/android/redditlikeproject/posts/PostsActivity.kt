package com.example.android.redditlikeproject.posts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.android.redditlikeproject.R
import com.example.android.redditlikeproject.data.entities.Post
import kotlinx.android.synthetic.main.activity_posts.*
import android.arch.lifecycle.ViewModelProvider
import android.os.PersistableBundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.android.redditlikeproject.RedditLikeApp
import com.example.android.redditlikeproject.vo.Resource
import com.example.android.redditlikeproject.vo.Status
import javax.inject.Inject


class PostsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit private var mViewModel: PostsViewModel
    val postsAdapter = PostsAdapter(ArrayList<Post>())
    var mSearchQuery: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        injectDependencies()
        a_posts_list.adapter = postsAdapter
        a_posts_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostsViewModel::class.java)
        observeViewModel()


    }

    fun observeViewModel() {
        mViewModel.result.observe(this, Observer { result -> observeResult(result) })
        mViewModel.query.observe(this, Observer { query -> mSearchQuery = query })
    }

    fun observeResult(resource: Resource<List<Post>>?) {
        resource.let {
            when (resource?.status) {
                Status.SUCCESS -> {
                    postsAdapter.updateData(resource.data)
                    showLoading(false)
                }
                Status.LOADING -> {
                    showLoading(true)
                    postsAdapter.updateData(resource.data)
                }
                Status.ERROR -> {
                    Toast.makeText(this@PostsActivity, "Something has gone wrong: ${resource.message}", Toast.LENGTH_SHORT).show()
                    showLoading(false)
                    postsAdapter.updateData(resource.data)
                }
            }
        }
    }

    fun showLoading(value: Boolean) {
        if (value) {
            a_posts_progress.visibility = View.VISIBLE
            a_posts_list.isEnabled = false
        } else {
            a_posts_progress.visibility = View.GONE
            a_posts_list.isEnabled = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.posts_menu, menu)
        val searchItem = menu!!.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                mViewModel.doSearch(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        searchItem.setOnActionExpandListener(object: MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                mViewModel.doSearch(null)
                return true
            }

        })


        if (!TextUtils.isEmpty(mSearchQuery)) {
            searchItem.expandActionView();
            searchView.setQuery(mSearchQuery, false);
            searchView.clearFocus();
        }

        return super.onCreateOptionsMenu(menu)
    }


    fun injectDependencies() {
        (application as RedditLikeApp).appComponent.inject(this)
    }


}


