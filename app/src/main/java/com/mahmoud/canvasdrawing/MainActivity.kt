package com.mahmoud.canvasdrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.core.view.doOnLayout
import com.mahmoud.canvasdrawing.ui.CanvasView
import com.mahmoud.canvasdrawing.ui.ClippedView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val canvasView = CanvasView(this).apply {
//            systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
//            contentDescription = getString(R.string.canvasContentDescription)
//        }

        val clippedView = ClippedView(this)
        setContentView(clippedView)

    }
}