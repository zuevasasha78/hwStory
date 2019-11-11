package com.example.hwstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_story.*
import java.util.*

class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        fullStory.text = getStory()
    }

    private fun getStory(): String {
        return when (intent.getStringExtra("storyType")) {
            "Скучная" -> readFile("/Users/user/hwStory/app/src/main/res/files/boring.txt")
            "Норм" -> readFile("/Users/user/hwStory/app/src/main/res/files/norm.txt")
            "Ну такое себе" -> readFile("/Users/user/hwStory/app/src/main/res/files/ny.txt")
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
