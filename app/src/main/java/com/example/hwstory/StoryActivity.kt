package com.example.hwstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_story.*
import java.util.*
import android.content.res.AssetManager
import android.app.Activity
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sun.jvm.hotspot.utilities.IntArray



class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        fullStory.text = getStory()
    }

    private fun getStory(): String {
        return when (intent.getStringExtra("storyType")) {
            "Скучная" -> readFile("boring.txt")
            "Норм" -> readFile("norm.txt")
            "Ну такое себе" -> readFile("ny.txt")
            else -> "Нет истории"
        }
    }

    private fun readFile(filePath: String): String {
        var text = ""
        val file = Scanner(filePath)
        while (file.hasNext()) {
            text = "$text ${file.next()}"
        }
        val words = intent.getShortArrayExtra("words")
        for (word in words) {
            text.format(word)
        }
        return text
    }
}
