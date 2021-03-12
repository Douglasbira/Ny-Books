package com.biradev.nytimesbooks.viewmodel.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biradev.nytimesbooks.model.ApiService
import com.biradev.nytimesbooks.model.BookBodyResponse
import com.biradev.nytimesbooks.model.dao.Books
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Books>> = MutableLiveData()

    fun  getBooks(){
      //  booksLiveData.value = createListBooks()



        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse> {

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {

                if (response.isSuccessful){
                    val books: MutableList<Books> = mutableListOf()

                    response.body()?.let {bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults){
                            val book = Books(
                                title = result.bookDetails[0].title,
                                author = result.bookDetails[0].author
                            )

                            books.add(book)
                        }

                    }


                     booksLiveData.value = books
                }


            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
        }
    }

    fun createListBooks(): List<Books>{
        return listOf(
            Books("Title 1", "Author 1"),
            Books("Title 2", "Author 2"),
            Books("Title 3", "Author 3"),
            Books("Title 4", "Author 4"),


            )
    }









