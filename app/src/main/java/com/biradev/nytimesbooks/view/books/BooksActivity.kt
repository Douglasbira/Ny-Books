package com.biradev.nytimesbooks.view.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.model.dao.Books
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setToolbar()

        setRecyclerView()


    }

    private fun setRecyclerView() {
        with(BooksAct_RecyclerView_ID){
            layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
            adapter = AdapterBooks(getBooks())
        }
    }

    private fun setToolbar() {
        BooksAct_Toolbar_ID.title = resources.getString(R.string.books)
        setSupportActionBar(BooksAct_Toolbar_ID)
    }

    fun getBooks(): List<Books>{
        return listOf(
            Books("Title 1", "Author 1"),
            Books("Title 2", "Author 2"),
            Books("Title 3", "Author 3"),
            Books("Title 4", "Author 4"),


        )
    }


}
