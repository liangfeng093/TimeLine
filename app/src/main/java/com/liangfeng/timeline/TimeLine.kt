package com.liangfeng.timeline

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by mzf on 2018/9/12.
 * Email:liangfeng093@gmail.com
 * Desc:
 */
class TimeLine : View {

    val TAG = this.javaClass.name

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    //画笔
    var paint = Paint()
    //
    var path = Path()
    //圆点半径
    var circleRadius = 50f
    //圆心的竖直距离
    var centerY = 0f
    var centerX = 0f
    //圆点个数
    var circleCount = 6
    //直线条数
    var lineCount = 0
    //直线长度
    var lineLength = centerX - circleRadius
    //填充数
    var fillCount = 1
    //Style 具体来说有三种： FILL, STROKE 和  FILL_AND_STROKE 。FILL 是填充模式，STROKE 是画线模式（即勾边模式）

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //设置画笔颜色
        paint?.color = Color.GREEN
        //测量后设置圆心s竖直距离
        centerY = (height / 4)?.toFloat()
        centerX = (width / (circleCount))?.toFloat()
        circleRadius = (height / 8)?.toFloat()
        var i = 1
        while (i < circleCount) {
            Log.e(TAG, ">>>>>>>i:" + i)
            //绘制圆
            if (i <= fillCount) {
                drawSolidCircle(i * centerX, centerY)
                canvas?.drawPath(path, paint)
            } else {
                drawHollowCircle(i * centerX, centerY)
                canvas?.drawPath(path, paint)
            }

            //绘制矩形(左上右下)
            paint.setStyle(Paint.Style.FILL)
            canvas?.drawRoundRect(i * centerX - 2 * circleRadius
                    , centerY + 2 * circleRadius
                    , i * centerX + 2 * circleRadius
                    , centerY + 4 * circleRadius
                    , 30f, 30f, paint)

            //绘制三角形
            paint?.strokeWidth = 1f
            path?.moveTo(i * centerX, centerY + circleRadius + 20f)
            path?.lineTo(i * centerX - circleRadius / 2, centerY + 2 * circleRadius)
            path?.lineTo(i * centerX + circleRadius / 2, centerY + 2 * circleRadius)
            path?.close()
            path?.moveTo(i * centerX + circleRadius, centerY)
            canvas?.drawPath(path, paint)

            //绘制文字
            paint?.color = Color.WHITE
            paint?.textSize = 50f
            paint?.strokeWidth = 5f
            when (i) {
                1 -> {
                    canvas?.drawText("今天", i * centerX - 2 * circleRadius + 20
                            , centerY + 3 * circleRadius + 16, paint)
                }
                2 -> {
                    canvas?.drawText("明天", i * centerX - 2 * circleRadius + 20
                            , centerY + 3 * circleRadius + 16, paint)
                }
                3 -> {
                    canvas?.drawText("后天", i * centerX - 2 * circleRadius + 20
                            , centerY + 3 * circleRadius + 16, paint)
                }
            }
            paint?.color = Color.GREEN
            i++
            //绘制线条
            if (i < circleCount) {
                //设置线条宽度
                paint?.strokeWidth = 10f
                lineLength = (i * centerX) - circleRadius
                path?.lineTo((i * centerX) - circleRadius, centerY)
                canvas?.drawPath(path, paint)
            }
        }
    }

    /**
     * 绘制进度
     */
    fun drawProgress() {

//        while () {
//
//        }
        /* Observable.timer(1, TimeUnit.SECONDS)
                 ?.subscribe {

                 }*/
    }

    /**
     * 绘制实心圆
     */
    fun drawSolidCircle(x: Float, y: Float) {
        paint.setStyle(Paint.Style.FILL)
        path?.addCircle(x, y, circleRadius, Path.Direction.CW)
    }

    /**
     * 绘制空心圆
     */
    fun drawHollowCircle(x: Float, y: Float) {
        Log.e(TAG, ">>>>>>>:绘制空心圆")
        paint.setStyle(Paint.Style.STROKE)
        path?.addCircle(x, y, circleRadius, Path.Direction.CW)
    }

}