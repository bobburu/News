package com.example.android.news;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public NewsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HeadlinesFrag();
            case 1:
                return new BusinessFrag();
            case 2:
                return new EntertainmentFrag();
            case 3:
                return new HealthFrag();
            case 4:
                return new ScienceFrag();
            case 5:
                return new SportsFrag();
            case 6:
                return new TechnologyFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return new String("Headlines");
            case 1:
                return new String("Business");
            case 2:
                return new String("Entertainment");
            case 3:
                return new String("Health");
            case 4:
                return new String("Science");
            case 5:
                return new String("Sports");
            case 6:
                return new String("Technology");
            default:
                return null;
        }
    }
}
