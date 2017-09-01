package com.example.wangdeyu.bottomtabdemo;

import android.content.Context;
import android.support.animation.SpringAnimation;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by wangdeyu on 17-8-31.
 */

public class SpringScrollView extends ScrollView {

    private float mStartDragRawX;
    private float mStartDragRawY;
    private SpringAnimation mSpringAnimation;

    protected OnSpringScrollChangeListener mOnSpringScrollChangeListener;


    public interface OnSpringScrollChangeListener {
        void onSpringScrollChange(SpringScrollView springScrollView, int l, int t, int oldl, int oldt);
    }

    public SpringScrollView(Context context) {
        this(context, null);
    }

    public SpringScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpringScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSpringAnimation = new SpringAnimation(this, SpringAnimation.TRANSLATION_Y, 0);
        //刚度 默认1200 值越大回弹的速度越快 springAnim.getSpring().setStiffness(800.0f); //阻尼 默认0.5 值越小，回弹之后来回的次数越多 springAnim.getSpring().setDampingRatio(0.50f);
        mSpringAnimation.getSpring().setStiffness(800.0f);
        //阻尼 默认0.5 值越小，回弹之后来回的次数越多
        mSpringAnimation.getSpring().setDampingRatio(0.50f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (getScaleY() <= 0) {
                    // 顶部下拉
                    if (mStartDragRawY == 0.0f) {
                        mStartDragRawY = ev.getRawY();
                    }

                    if (ev.getRawY() > mStartDragRawY) {
                        setTranslationY((ev.getRawY() - mStartDragRawY) / 3);
                        return true;
                    } else {
                        mSpringAnimation.cancel();
                        setTranslationY(0);
                    }
                } else if ((getScrollY() + getHeight()) >= getChildAt(0).getMeasuredHeight()) {
                    // 底部上拉
                    if (mStartDragRawY == 0.0f) {
                        mStartDragRawY = ev.getRawY();
                    }

                    if (ev.getRawY() < mStartDragRawY) {
                        setTranslationY((ev.getRawY() - mStartDragRawY) / 3);
                        return true;
                    } else {
                        mSpringAnimation.cancel();
                        setTranslationY(0);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (getTranslationY() != 0) {
                    mSpringAnimation.start();
                }
                mStartDragRawY = 0;
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setOnSpringScrollChangeListener(OnSpringScrollChangeListener listener) {
        mOnSpringScrollChangeListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (null != mOnSpringScrollChangeListener) {
            mOnSpringScrollChangeListener.onSpringScrollChange(SpringScrollView.this, l, t, oldl, oldt);
        }
        LogUtils.d("view, l: " + l + ", t: " + l + ", oldl: " + oldl + ", oldt: " + oldt);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }
}
