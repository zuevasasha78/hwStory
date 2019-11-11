package com.example.hwstory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fill_words.*

val  wordAmountTotal = 5

class FillWordsActivity : AppCompatActivity() {

    private var wordAmount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_words)
        word_left.text = word_left.text.toString().format(wordAmountTotal)
    }


    fun clickOk(view: View) {
        val words = ArrayList<String>()
        if (wordAmount != wordAmountTotal) {
            words.add(editText.text.toString())
            wordAmount += 1

        } else {
            val lastIntent = Intent(this, StoryActivity::class.java)
            lastIntent.putExtra("storyType", intent.getStringExtra("storyType"))
            lastIntent.putExtra("words", words)
            startActivity(lastIntent)
        }
    }
}
