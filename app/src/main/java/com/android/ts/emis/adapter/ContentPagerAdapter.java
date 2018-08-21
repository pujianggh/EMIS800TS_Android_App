package com.android.ts.emis.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 分类-Fragment分类Adapter
 *
 * @author pujiang
 * @date 2017-9-28 10:17
 * @mail 515210530@qq.com
 * @Description:
 */
public class ContentPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public ContentPagerAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
