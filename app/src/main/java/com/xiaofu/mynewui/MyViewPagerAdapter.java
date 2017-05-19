package com.xiaofu.mynewui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyViewPagerAdapter extends FragmentPagerAdapter{
    private static final String[] name = {"黄家驹","黄贯中","叶世荣","黄家强"};
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ResumeFragment.Instant(position);
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
