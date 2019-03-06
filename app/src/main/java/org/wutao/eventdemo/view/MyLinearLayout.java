package org.wutao.eventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {

    public static final String TAG = "ED";

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *1. ACTION_DOWN，手动返回true; 上传按下事件，接收后续事件，但不会下传，onclick事件不触发
     *                      false; 上传按下事件，不接收后续事件
     *
     *1. ACTION_MOVE，手动返回true; 上传移动事件，接收后续其他事件并下传，onclick事件触发
     *                      false; 上传移动事件，接收后续其他事件并下传，onclick事件触发
     *
     *
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = false;
        String name = "";

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                name = "按下";
                Log.d(TAG, "MyLinearLayout dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "MyLinearLayout dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "MyLinearLayout dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "MyLinearLayout dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
        }
        Log.d(TAG, "MyLinearLayout dispatchTouchEvent() " + name + ret);
        return ret;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean ret = false;
        String name = "";

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                name = "按下";
                Log.d(TAG, "MyLinearLayout onInterceptTouchEvent() " + name);
                ret = super.onInterceptTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "MyLinearLayout onInterceptTouchEvent() " + name);
                ret = super.onInterceptTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "MyLinearLayout onInterceptTouchEvent() " + name);
                ret = super.onInterceptTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "MyLinearLayout onInterceptTouchEvent() " + name);
                ret = super.onInterceptTouchEvent(ev);
                break;
        }
        Log.d(TAG, "MyLinearLayout onInterceptTouchEvent() " + name + ret);
        return ret;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean ret = false;
        String name = "";

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                name = "按下";
                Log.d(TAG, "MyLinearLayout onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "MyLinearLayout onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "MyLinearLayout onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "MyLinearLayout onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
        }
        Log.d(TAG, "MyLinearLayout onTouchEvent() " + name + ret);
        return ret;
    }
}
