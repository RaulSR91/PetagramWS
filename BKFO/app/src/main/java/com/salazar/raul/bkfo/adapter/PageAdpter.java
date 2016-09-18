package com.salazar.raul.bkfo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 17/07/2016.
 */
public class PageAdpter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public PageAdpter(FragmentManager fm ,  ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
