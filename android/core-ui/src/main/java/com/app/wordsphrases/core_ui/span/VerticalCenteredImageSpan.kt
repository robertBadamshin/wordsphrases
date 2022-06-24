package com.app.wordsphrases.core_ui.span

import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan

class VerticalCenteredImageSpan(
    private val rightMarginInPx: Int = 0,
    private val leftMarginInPx: Int = 0,
    drawable: Drawable
) : ImageSpan(drawable) {

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fontMetricsInt: Paint.FontMetricsInt?
    ): Int {
        val boundsRectangle = drawable.bounds
        if (fontMetricsInt != null) {
            val fontMetricsPaint = paint.fontMetricsInt
            val fontHeight = fontMetricsPaint.descent - fontMetricsPaint.ascent
            val drawableHalfHeight = (boundsRectangle.bottom - boundsRectangle.top) / 2
            val centerY = fontMetricsPaint.ascent + fontHeight / 2

            fontMetricsInt.ascent = centerY - drawableHalfHeight
            fontMetricsInt.top = fontMetricsInt.ascent
            fontMetricsInt.bottom = centerY + drawableHalfHeight
            fontMetricsInt.descent = fontMetricsInt.bottom
        }
        return boundsRectangle.right + rightMarginInPx + leftMarginInPx
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        xPosition: Float,
        top: Int,
        baselineY: Int,
        bottom: Int,
        paint: Paint
    ) {
        canvas.save()
        val fontMetricsPaint = paint.fontMetricsInt
        val fontHeight = fontMetricsPaint.descent - fontMetricsPaint.ascent
        val centerY = baselineY + fontMetricsPaint.descent - fontHeight / 2
        val translationY = centerY - (drawable.bounds.bottom - drawable.bounds.top) / 2
        canvas.translate(xPosition, translationY.toFloat())
        drawable.draw(canvas)
        canvas.restore()
    }
}