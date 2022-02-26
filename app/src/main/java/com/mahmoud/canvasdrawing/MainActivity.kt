package com.mahmoud.canvasdrawing

import android.graphics.Color
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import com.mahmoud.canvasdrawing.databinding.ActivityMainBinding
import com.mahmoud.canvasdrawing.ui.CanvasView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeColor.setOnClickListener {
            binding.canvasView.changeColor(Color.RED)
        }

        binding.buttonClear.setOnClickListener {
            binding.canvasView.clear()
        }

//        val canvasView = CanvasView(this).apply {
//            systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
//            contentDescription = getString(R.string.canvasContentDescription)
//        }
//
////        val clippedView = ClippedView(this)
//        setContentView(canvasView)

    }
}