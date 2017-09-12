package org.wutao.eventdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * 事件冲突，SwipeRefreshLayout嵌套多布局RecyclerView，item是ViewPager
 * ViewPager设置onTouch事件监听解决，判断滑动方向
 */
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private static final String TAG = "MainActivity";

    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_refresh);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第" + i + "条数据");
        }
        MyAdapter adapter = new MyAdapter(this, list);
        adapter.setOnTouchListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:// 经测试，ViewPager的DOWN事件不会被分发下来
                Log.d(TAG, "onTouch: ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                if (mRefreshLayout.isRefreshing()) {
                    mRefreshLayout.setRefreshing(false);
                }
                Log.d(TAG, "onTouch: ACTION_MOVE");
                mRefreshLayout.setEnabled(false);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouch: ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "onTouch: ACTION_CANCEL");
                mRefreshLayout.setEnabled(true);
                break;
        }
        return false;
    }
}
