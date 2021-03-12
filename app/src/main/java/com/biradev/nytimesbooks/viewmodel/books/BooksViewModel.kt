package com.biradev.nytimesbooks.viewmodel.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.model.ApiService
import com.biradev.nytimesbooks.model.BookBodyResponse
import com.biradev.nytimesbooks.model.dao.Books
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Books>> = MutableLiveData()
    val flipperLiveData : MutableLiveData<Pair<Int,Int?>> = MutableLiveData()

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
                            val book = result.bookDetails[0].getBookModel()

                            books.add(book)
                        }

                    }


                     booksLiveData.value = books
                     flipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS,null)
                }else if (response.code() == 401){
                    flipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_erro_401)
                }else{
                    flipperLiveData.value = Pair(VIEW_FLIPPER_ERROR,R.string.books_erro_400)
                }


            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                flipperLiveData.value = Pair(VIEW_FLIPPER_ERROR,R.string.books_erro_500)


            }

        })
        }


    companion object{
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }

    }


  /*  fun createListBooks(): List<Books>{
        return listOf(
            Books("Title 1", "Author 1"),
            Books("Title 2", "Author 2"),
            Books("Title 3", "Author 3"),
            Books("Title 4", "Author 4"),


            )
    }*/









