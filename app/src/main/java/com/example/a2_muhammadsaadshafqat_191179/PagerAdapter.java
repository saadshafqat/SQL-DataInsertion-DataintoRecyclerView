package com.example.a2_muhammadsaadshafqat_191179;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
private int numberofTabs;
    public PagerAdapter(FragmentManager fm, int numberofTabs){
        super(fm);
        this.numberofTabs=numberofTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new InsertFragment();
            case 1:
                return new GetDataFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberofTabs;
    }
}
