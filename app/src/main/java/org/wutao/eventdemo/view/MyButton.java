package org.wutao.eventdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {
    public static final String TAG = "ED";

    public MyButton(Context context) {
        super(context);
    }
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = false;
        String name = "";

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                name = "按下";
                Log.d(TAG, "MyButton dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "MyButton dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "MyButton dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "MyButton dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
        }
        Log.d(TAG, "MyButton dispatchTouchEvent() " + name + ret);
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
                Log.d(TAG, "MyButton onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "MyButton onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "MyButton onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "MyButton onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
        }
        Log.d(TAG, "MyButton onTouchEvent() " + name + ret);
        return ret;
    }
}
