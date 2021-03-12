package com.biradev.nytimesbooks.model

import com.biradev.nytimesbooks.model.dao.Books
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    @Json(name = "results")
    val bookResults: List<BookResultsResponse>




)

@JsonClass(generateAdapter = true)
 data class BookResultsResponse (
    @Json(name = "book_details")
    val bookDetails: List<BookDetailsResponse>
)

@JsonClass(generateAdapter = true)
data class BookDetailsResponse (
    @Json(name = "title")
    val title: String,

    @Json(name = "author")
    val author: String,

    @Json(name = "description")
    val description: String





){
    fun getBookModel() = Books(
        title = this.title,
        author = this.author,
        description = this.description
    )
}

