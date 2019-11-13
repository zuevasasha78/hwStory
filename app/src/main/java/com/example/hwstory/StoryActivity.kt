package com.example.hwstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_story.*
import java.io.BufferedReader

class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        fullStory.text = getStory()
    }

    private fun getStory(): String {
        return when (intent.getStringExtra("storyType")) {
            "Скучная" -> preparingText("files/boring.txt")
            "Норм" -> preparingText("files/norm.txt")
            "Ну такое себе" -> preparingText("files/ny.txt")
            else -> "Нет истории"
        }
    }

    private fun preparingText(filePath: String): String {
        val text = readFileFromAssets(filePath)
        val words = intent.getStringArrayListExtra("words")
        for (word in words) {
            text.replace("word", word)
        }
        return text
    }

    private fun readFileFromAssets(path: String): String {
        var am = this.assets
        var stream = am.open(path)
        val text = stream.bufferedReader().use(BufferedReader::readText)
        stream.close()
        return text
    }
}
