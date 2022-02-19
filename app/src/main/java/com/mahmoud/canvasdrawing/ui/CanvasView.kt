package com.mahmoud.canvasdrawing.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.mahmoud.canvasdrawing.R


private const val STROKE_WIDTH = 12f

class CanvasView (
    context: Context
): View(context) {

    private val TAG = "CanvasViewTag"

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap


    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)
    private val drawingColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)


    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f

    private val path = Path()
    private val paint = Paint().apply {
        color = drawingColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }

        return true
    }

    private fun touchStart() {}

    private fun touchMove() {}

    private fun touchUp() {}


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        Log.d(TAG, "onSizeChanged: new=$w:$h | old=$oldw:$oldh")

        if (::extraBitmap.isInitialized) extraBitmap.recycle()

        extraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)

        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(extraBitmap, 0f, 0f, null)
    }
}