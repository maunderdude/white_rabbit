package com.example.the_rabbit_hole

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnView = findViewById<Button>(R.id.btnRedPill)
        val btnView2 = findViewById<Button>(R.id.btnBluePill)

        // Comment for commit

        val videoView = findViewById<VideoView>(R.id.videoView )
        val mp = MediaController(this)

        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.rain_}")
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()



        videoView.setOnPreparedListener(MediaPlayer.OnPreparedListener {
            @Override
            fun onPrepared(mp: MediaPlayer) {
                mp.setLooping(true);
            }
        })



    }
    override fun onBackPressed() {}


    fun onFade(view : View){
        val videoView = findViewById<VideoView>(R.id.videoView )
        val imageView = findViewById<ImageView>(R.id.imageView)
        var isFade = true

        if(isFade){
            isFade = false
            videoView.animate().alpha(0f).setDuration(9000)
            imageView.animate().alpha(1f).setDuration(5000)

        }

    }

    fun onRedPill(view: View){
        Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT).show()
    }

    fun onBluePill(view: View){
        Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT).show()
    }
}
