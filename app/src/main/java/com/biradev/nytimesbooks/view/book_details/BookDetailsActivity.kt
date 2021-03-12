package com.biradev.nytimesbooks.view.book_details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.biradev.nytimesbooks.R
import com.biradev.nytimesbooks.view.BasicActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BookDetailsActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        setupToolbar(IncludeToolbar_Toolbar_ID, R.string.details,true)

        BookDetailsAct_TextView_Title_ID.text = intent.getStringExtra(EXTRA_TITLE)
        BookDetailsAct_TextView_Description_ID.text = intent.getStringExtra(EXTRA_DESCRIPTION)


    }





    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"


        fun getStartIntent(context: Context, title: String, description: String): Intent{
            return Intent(context,BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE,title)
                putExtra(EXTRA_DESCRIPTION, description)
            }

        }
    }
}
