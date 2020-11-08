package com.example.pracnavigationsecertstuff.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Integer.min
import kotlin.math.cos
import kotlin.math.sin

class Xmen(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Radius of the circle
    var radius: Float = 0.0f
    var borderWidth = 10.0f

    val paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        isAntiAlias = true
        isDither = true

    }

    val circleBoarder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = borderWidth
    }



    /**
     *  Called on initial load to check the size of the view, then only called if the view size
     *  is changed.
     */
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (min(w, h) / 2 * 0.8).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircle(canvas)
        drawX(canvas)
    }


    fun drawCircle(canvas: Canvas) {
        /**
         * drawCircle
         * cx: the center position of x
         * cy: the center position of y
         * radius: The radius of the circle
         * Paint: the paint used to draw the circle.
         */
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paintCircle)
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, circleBoarder)
    }

    fun drawX(canvas: Canvas) {

        var centerX = width / 2.0f
        var centerY = height / 2.0f
        var startAngle = 45.0
        var endAngle = 225.0
        var startX= centerX + (cos(Math.toRadians(startAngle)) * radius).toFloat()
        var startY = centerY + (sin(Math.toRadians(startAngle)) * radius).toFloat()
        var endX = centerX + (cos(Math.toRadians(endAngle)) * radius).toFloat()
        var endY = centerY + (sin(Math.toRadians(endAngle)) * radius).toFloat()

        /**
         * startX: The x-coordinate of the start point of the line.
         * startY: the y-coordinate of the start point of the line.
         * stopX:
         * stopY:
         * paint: The paint used to draw the line.
         */
        canvas.drawLine(startX, startY, endX, endY, circleBoarder)


        centerX = width / 2.0f
        centerY = height / 2.0f
        startAngle = 135.0
        endAngle = 315.0
        startX= centerX + (cos(Math.toRadians(startAngle)) * radius).toFloat()
        startY = centerY + (sin(Math.toRadians(startAngle)) * radius).toFloat()
        endX = centerX + (cos(Math.toRadians(endAngle)) * radius).toFloat()
        endY = centerY + (sin(Math.toRadians(endAngle)) * radius).toFloat()
        canvas.drawLine(startX, startY, endX, endY, circleBoarder)

    }

}