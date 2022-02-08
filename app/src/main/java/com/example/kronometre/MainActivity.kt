package com.example.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    var zamaniDurdur : Long = 0

    fun start(view : View){
        kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur
        kronometre.start()
        btnStart.visibility = View.INVISIBLE
        btnPause.visibility = View.VISIBLE
        imageView.setImageDrawable(getDrawable(R.drawable.pause))
    }

    fun pause(view: View){
        zamaniDurdur = kronometre.base-SystemClock.elapsedRealtime()
        kronometre.stop()
        btnPause.visibility = View.INVISIBLE
        btnStart.visibility = View.VISIBLE
        imageView.setImageDrawable((getDrawable(R.drawable.start)))
    }

    fun reset(view: View){
        kronometre.base = SystemClock.elapsedRealtime()
        kronometre.stop()
        zamaniDurdur = 0
        btnPause.visibility = View.INVISIBLE
        btnStart.visibility = View.VISIBLE
        imageView.setImageDrawable( getDrawable(R.drawable.start))
    }
}