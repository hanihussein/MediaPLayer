package com.hani.mediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.hani.mediaplayer.mediacontrol.AudioDataItem
import com.hani.mediaplayer.mediacontrol.MEDIA_SOURCE_URL
import com.hani.mediaplayer.mediacontrol.MediaPlayerManager
import com.hani.mediaplayer.mediacontrol.MediaType
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mediaManager = MediaPlayerManager(applicationContext)


        findViewById<AppCompatButton>(R.id.play_btn).setOnClickListener {

            val audioDataItem = AudioDataItem(
                1,
                MEDIA_SOURCE_URL,
                "https://www.kozco.com/tech/LRMonoPhase4.mp3"
            )

            mediaManager.addMedia(audioDataItem)
            mediaManager.prepare(0)
            mediaManager.play()
        }
    }
}