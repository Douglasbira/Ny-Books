package com.biradev.nytimesbooks.viewmodel.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biradev.nytimesbooks.model.dao.Books

class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Books>> = MutableLiveData()

    fun  getBooks(){
        booksLiveData.value = createListBooks()


    }

    fun createListBooks(): List<Books>{
        return listOf(
            Books("Title 1", "Author 1"),
            Books("Title 2", "Author 2"),
            Books("Title 3", "Author 3"),
            Books("Title 4", "Author 4"),


            )
    }


}