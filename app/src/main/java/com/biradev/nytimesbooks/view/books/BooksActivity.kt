package com.biradev.nytimesbooks.view.books


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.model.dao.Books
import com.biradev.nytimesbooks.view.BasicActivity
import com.biradev.nytimesbooks.view.book_details.BookDetailsActivity
import com.biradev.nytimesbooks.viewmodel.books.BooksViewModel
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksActivity : BasicActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)



        setupToolbar(IncludeToolbar_Toolbar_ID, R.string.books)



        val view_model = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        view_model.booksLiveData.observe(this, Observer {
            it?.let { books ->
                setRecyclerView(books)


            }
        })

        view_model.getBooks()


        view_model.flipperLiveData.observe(this, Observer {
            it?.let {flipper ->
                BooksAct_ViewFlipper_ID.displayedChild = flipper.first

                flipper.second?.let { message_error ->
                    BooksAct_TextView_Error_ID.text = getString(message_error)
                }


            }

        })

    }

    private fun setRecyclerView(books: List<Books> ) {
        with(BooksAct_RecyclerView_ID){
            layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
            adapter = AdapterBooks(books){book ->
            val intent = BookDetailsActivity.getStartIntent(this@BooksActivity,book.title,book.description)
            startActivity(intent)
            }
        }
    }





}
