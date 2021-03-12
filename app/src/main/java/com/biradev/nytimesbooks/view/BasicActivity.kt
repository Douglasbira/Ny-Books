package com.biradev.nytimesbooks.view

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BasicActivity : AppCompatActivity() {

     protected fun setupToolbar(toolbar: Toolbar, titleRes: Int, showBackButton: Boolean = false ){
         toolbar.title = getString(titleRes)
         setSupportActionBar(toolbar)
         if (showBackButton){
             supportActionBar?.setDisplayHomeAsUpEnabled(true)
         }

     }
}