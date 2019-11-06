package com.example.santanu.day11_2;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                HomeFragment home = new HomeFragment();
                return home;
            case 1:
                AboutFragment about = new AboutFragment();
                return about;
            case 2:
                ContactFragment contact = new ContactFragment();
                return contact;
            default:
                return null;
        }
    }
}
