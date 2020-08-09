package com.jackykeke.toastee

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun error(view: View) {
        Toastee.getInstance()
            .icon(R.drawable.ic_clear_white_24dp)
            .common(R.color.errorColor, R.color.defaultTextColor)
            .gravity(Gravity.TOP, 0, 0)
            .message("????")
            .withIcon(true)
            .build(this)

    }

    fun success(view: View) {
        Toastee.getInstance()
            .icon(R.drawable.ic_check_white_24dp)
            .common(R.color.successColor, R.color.defaultTextColor)
            .gravity(Gravity.CENTER, 0, 0)
            .message("success")
            .withIcon(true)
            .build(this)

    }

    fun info(view: View) {
        Toastee.getInstance()
            .icon(R.drawable.ic_info_outline_white_24dp)
            .common(R.color.infoColor, R.color.defaultTextColor)
            .gravity(Gravity.BOTTOM, 0, 0)
            .message("info")
            .withIcon(true)
            .build(this)
    }

    fun withoutIcon(view: View) {
        Toastee.getInstance()
            .common(R.color.warningColor, R.color.defaultTextColor)
            .gravity(Gravity.BOTTOM, 0, 0)
            .message("withoutIcon")
            .withIcon(false)
            .build(this)
    }

    fun custom(view: View) {

        val toastLayout =
            (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.toast_custom_layout,
                null
            )

        Toastee.getInstance()
            .layout(toastLayout)
            .gravity(Gravity.BOTTOM, 0, 0)
            .custom(this)

    }

    fun gravity(view: View) {

        Toastee.getInstance()
            .common(R.color.warningColor, R.color.defaultTextColor)
            .gravity(Gravity.CENTER, 350, 150)
            .message("gravity： x:350 y:150")
            .withIcon(false)
            .build(this)

    }


}