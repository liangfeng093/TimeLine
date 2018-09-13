package com.liangfeng.timeline

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var animator = ObjectAnimator.ofFloat(line, "length", 140f)
//        var animator = ObjectAnimator.ofFloat(circle, "circleRadius", 0f, 100f)
        animator?.setDuration(3 * 1000)
        animator?.start()
    }
}
