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
class Line : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //画笔
    var paint = Paint()
    //
    var path = Path()


    var length = 0f
        set(value) {
            field = value
            invalidate()
        }
//        get() {
//            return this.length
//        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint?.strokeWidth = 10f
        canvas?.drawLine(0f, (height / 2)?.toFloat(), length, (height / 2)?.toFloat(), paint)
//        canvas?.drawLine(0f, (height / 2)?.toFloat(), width?.toFloat(), (height / 2)?.toFloat(), paint)
    }

}