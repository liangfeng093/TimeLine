package com.liangfeng.timeline

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Created by mzf on 2018/9/13.
 * Email:liangfeng093@gmail.com
 * Desc:
 */
class HollowCircle:View{


    //画笔
    var paint = Paint()
    //
    var path = Path()

    //圆点半径
    var circleRadius = 50f
        set(value) {
            field = value
            invalidate()
        }
        /*get() {
            return circleRadius
        }*/
    //圆心的竖直距离
    var centerY = 0f
    var centerX = 0f

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        centerX = (width / 2)?.toFloat()
        centerY = (height / 2)?.toFloat()

        canvas?.drawCircle(centerX, centerY, circleRadius, paint)

    }

}