package com.example.hwstory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startStory(view: View) {
        val storyType = spinner.selectedItem.toString()
        val intent = Intent(this, FillWordsActivity::class.java)
        intent.putExtra("storyType", storyType)
        startActivity(intent)
    }

}
