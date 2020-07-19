package com.jackykeke.toastee;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

public class Toastee {

    private static Toast lastToast = null;
    private static Toast nowToast = null;

    private static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    private static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;
    private static int textSize = 16; // in SP

    private static boolean tintIcon = true;
    private static boolean allowQueue = true;
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;

    private int duration = LENGTH_SHORT;
    private int gravity = Gravity.CENTER;

    @DrawableRes
    private int iconRes;

    @ColorRes
    private int tintColor = R.color.normalColor;

    @ColorRes
    private int textColor = R.color.defaultTextColor;

    private String msgRes;
    private boolean withIcon = true;

    private View layout;

    private Toastee() {
        // avoiding instantiation

    }

    private static Toastee instance;

    public static Toastee getInstance() {
        if (instance == null) {
            synchronized (Toastee.class) {
                if (instance == null)
                    instance = new Toastee();
            }
        }
        return instance;
    }

    public Toastee icon(@DrawableRes int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public Toastee message(String msgRes) {
        this.msgRes = msgRes;
        return this;
    }

    public Toastee gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }


    public Toastee duration(int duration) {
        this.duration = duration;
        return this;
    }

    public Toastee withIcon(boolean b) {
        this.withIcon = b;
        return this;
    }

    public Toastee common(@ColorRes int tintColor, @ColorRes int textColor) {
        this.tintColor = tintColor;
        this.textColor = textColor;
        return this;
    }

    public void build(Context context) {

        nowToast = Toast.makeText(context, "", duration);
        nowToast.setGravity(gravity, 0, 0);

        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout, null);
        final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);

        Drawable drawableFrame;
        if (tintColor != R.color.normalColor)
            drawableFrame = ToastyUtils.tint9PatchDrawableFrame(context, ToastyUtils.getColor(context, tintColor));
        else
            drawableFrame = ToastyUtils.getDrawable(context, R.drawable.toast_frame);
        ToastyUtils.setBackground(toastLayout, drawableFrame);

        if (withIcon) {
            if (iconRes == 0)
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            ToastyUtils.setBackground(toastIcon, tintIcon ? ToastyUtils.tintIcon(
                    ToastyUtils.getDrawable(context, iconRes), ToastyUtils.getColor(context, textColor)) :
                    ToastyUtils.getDrawable(context, iconRes));
        } else {
            toastIcon.setVisibility(View.GONE);
        }

        toastTextView.setTextColor(ToastyUtils.getColor(context, textColor));
        toastTextView.setText(msgRes);
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        toastTextView.setTypeface(currentTypeface);

        nowToast.setView(toastLayout);
        if (!allowQueue) {
            if (lastToast != null)
                lastToast.cancel();
            lastToast = nowToast;
        }
        nowToast.show();
    }

    public Toastee layout(View view) {
        this.layout = view;
        return this;
    }


    public void custom(Context context) {
        nowToast = Toast.makeText(context, "", duration);
        nowToast.setGravity(gravity, 0, 0);
        nowToast.setView(layout);
        nowToast.show();
    }


}
