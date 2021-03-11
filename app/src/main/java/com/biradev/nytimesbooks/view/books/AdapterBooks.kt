package com.biradev.nytimesbooks.view.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.model.dao.Books
import kotlinx.android.synthetic.main.item_books.view.*


class AdapterBooks(val books: List<Books>) : RecyclerView.Adapter<AdapterBooks.BooksViewHolder>(){


    class BooksViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        private val title = itemview.ItemBooks_TextView_Title_ID
        private val author = itemview.ItemBooks_TextView_Author_ID

        fun bindView(books: Books){
            title.text = books.title
            author.text = books.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_books,parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

        holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()


}