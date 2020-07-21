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
            .gravity(Gravity.TOP)
            .message("????")
            .withIcon(true)
            .build(this)

    }

    fun success(view: View) {
        Toastee.getInstance()
            .icon(R.drawable.ic_check_white_24dp)
            .common(R.color.successColor, R.color.defaultTextColor)
            .gravity(Gravity.CENTER)
            .message("success")
            .withIcon(true)
            .build(this)

    }

    fun info(view: View) {
        Toastee.getInstance()
            .icon(R.drawable.ic_info_outline_white_24dp)
            .common(R.color.infoColor, R.color.defaultTextColor)
            .gravity(Gravity.BOTTOM)
            .message("info")
            .withIcon(true)
            .build(this)
    }

    fun withoutIcon(view: View) {
        Toastee.getInstance()
            .common(R.color.warningColor, R.color.defaultTextColor)
            .gravity(Gravity.BOTTOM)
            .message("withoutIcon")
            .withIcon(false)
            .build(this)
    }

    fun custom(view: View) {
        val toastLayout = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.toast_custom_layout, null)

        Toastee.getInstance()
            .layout(toastLayout)
            .gravity(Gravity.BOTTOM)
            .custom(this)

    }


}