package org.wutao.eventdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 凸显 on 2016/12/9.
 */

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<Integer> mItems;

    public MyPagerAdapter(Context context, List<Integer> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret = null;
        ImageView img = new ImageView(mContext);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setImageResource(mItems.get(position % mItems.size()));
        ret = img;
        container.addView(ret);
        return ret;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
