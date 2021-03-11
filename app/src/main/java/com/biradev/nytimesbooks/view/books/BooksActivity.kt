package com.biradev.nytimesbooks.view.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.model.dao.Books
import com.biradev.nytimesbooks.viewmodel.books.BooksViewModel
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setToolbar()


       val view_model = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        view_model.booksLiveData.observe(this, Observer {
            it?.let { books ->
                setRecyclerView(books)


            }
        })

        view_model.getBooks()

    }

    private fun setRecyclerView(books: List<Books> ) {
        with(BooksAct_RecyclerView_ID){
            layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
            adapter = AdapterBooks(books)
        }
    }

    private fun setToolbar() {
        BooksAct_Toolbar_ID.title = resources.getString(R.string.books)
        setSupportActionBar(BooksAct_Toolbar_ID)
    }




}
