package com.xiaofu.mynewui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyImagerPageAdapter extends PagerAdapter {
    private Context mContext;

    private static final int res[] = {R.mipmap.beyond2,R.mipmap.beyond3,R.mipmap.beyond4,R.mipmap.beyond5};

    public MyImagerPageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return res.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(lp);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(res[position]);
        container.addView(imageView);
        return imageView;
    }
}
