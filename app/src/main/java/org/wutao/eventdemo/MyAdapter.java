package org.wutao.eventdemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 凸显 on 2016/12/9.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private static final String TAG = "MyAdapter";
    private Context mContext;
    private List<String> mList;
    private View.OnTouchListener mOnTouchListener;

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        mOnTouchListener = onTouchListener;
    }

    public MyAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View itemview=null;
        switch (viewType) {
            case 0:
                itemview=layoutInflater.inflate(R.layout.item_head,parent,false);
                return new MyViewHolder2(itemview);
            case 1:
                 itemview = layoutInflater.inflate(R.layout.item_view, parent, false);
                return new MyViewHolder(itemview);
        }

        return new MyViewHolder(itemview);
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        if (position == 0) {
            type = 0;
        } else {
            type = 1;
        }
        return type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            MyViewHolder2 viewHolder2 = (MyViewHolder2) holder;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(R.mipmap.ic_launcher);
            list.add(R.mipmap.ic_launcher);
            list.add(R.mipmap.ic_launcher);
            list.add(R.mipmap.ic_launcher);
            viewHolder2.mPager.setAdapter(new MyPagerAdapter(mContext,list));
            if (mOnTouchListener != null) {
                viewHolder2.mPager.setOnTouchListener(mOnTouchListener);
            }

        }else {
            String text = mList.get(position);
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.mTextView.setText(text);

        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;


        public MyViewHolder(View itemView ) {
            super(itemView);
            mTextView = ((TextView) itemView.findViewById(R.id.item_text));

        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        public ViewPager mPager;


        public MyViewHolder2(View itemView ) {
            super(itemView);
            mPager = ((ViewPager) itemView.findViewById(R.id.item_viewpager));

        }
    }

}
