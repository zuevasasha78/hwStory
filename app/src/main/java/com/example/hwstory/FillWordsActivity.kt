package com.example.hwstory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fill_words.*


class FillWordsActivity : AppCompatActivity() {

    private val wordAmountTotal = 5
    private var wordAmount = 0
    private val words = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_words)
        word_left.text = word_left.text.toString().format(wordAmountTotal)
    }


    fun clickOk(view: View) {
        if (editText.text.toString() != "") {
            words.add(editText.text.toString())
            wordAmount += 1
            if (wordAmount != wordAmountTotal) {
                word_left.text = getString(R.string.word_left_label)
                        .format(wordAmountTotal - wordAmount)
                editText.text.clear()

            } else {
                val lastIntent = Intent(this, StoryActivity::class.java)
                val storyType = intent.getStringExtra("storyType")
                lastIntent.putExtra("storyType", storyType)
                lastIntent.putExtra("words", words)
                startActivity(lastIntent)
            }
        }
    }
}

