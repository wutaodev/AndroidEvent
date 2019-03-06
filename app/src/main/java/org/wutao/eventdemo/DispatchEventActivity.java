package org.wutao.eventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 *  若 ACTION_DOWN 事件 返回false，后续事件将收不到
 *
 *  参考链接：
 *  https://blog.csdn.net/carson_ho/article/details/54136311
 */
public class DispatchEventActivity extends AppCompatActivity {
    public static final String TAG = "ED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_event);
    }


    /**
     * 1. ACTION_DOWN，手动返回true;按下事件结束，接收后续事件，但不会下传，onclick事件不触发
     *                      false; 按下事件结束，接收后续事件，但不会下传，onclick事件不触发
     *
     * 2. ACTION_MOVE，手动返回true；move事件不会往下传，后续事件将继续往下传,能onclick事件触发
     *                         false；move事件不会往下传，后续事件将继续往下传,能onclick事件触发
     *
     * 2. ACTION_UP，手动返回true; 事件直接结束，onclick事件不触发
     *                      fasle; 事件直接结束，onclick事件不触发
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = false;
        String name = "";

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                name = "按下";
                Log.d(TAG, "DispatchEventActivity dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "DispatchEventActivity dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "DispatchEventActivity dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "DispatchEventActivity dispatchTouchEvent() " + name);
                ret = super.dispatchTouchEvent(ev);
                break;
        }
        Log.d(TAG, "DispatchEventActivity dispatchTouchEvent() " + name + ret);
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
                Log.d(TAG, "DispatchEventActivity onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                name = "移动";
                Log.d(TAG, "DispatchEventActivity onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_UP:
                name = "抬起";
                Log.d(TAG, "DispatchEventActivity onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
            case MotionEvent.ACTION_CANCEL:
                name = "取消";
                Log.d(TAG, "DispatchEventActivity onTouchEvent() " + name);
                ret = super.onTouchEvent(ev);
                break;
        }
        Log.d(TAG, "DispatchEventActivity onTouchEvent() " + name + ret);
        return ret;
    }

    /**
     *
     * 只要按下和抬起事件传到button，事件就会被触发
     */
    public void onclick(View view) {
        Log.d(TAG, "button onclick: ");
    }
}
