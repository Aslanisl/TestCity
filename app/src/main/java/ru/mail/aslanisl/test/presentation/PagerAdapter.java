package ru.mail.aslanisl.test.presentation;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.mail.aslanisl.test.App;
import ru.mail.aslanisl.test.R;

/**
 * Created by Ivan on 31.01.2018.
 */

public class PagerAdapter extends FragmentPagerAdapter{
    public static final int SHARES_PAGE = 0;
    public static final int EVENTS_POSTERS_PAGE = 1;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case SHARES_PAGE:
                return RecyclerFragment.newInstance(RecyclerFragment.Type.SHARES);
            case EVENTS_POSTERS_PAGE:
                return RecyclerFragment.newInstance(RecyclerFragment.Type.EVENTS);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case SHARES_PAGE:
                return App.getAppContext().getString(R.string.shares);
            case EVENTS_POSTERS_PAGE:
                return App.getAppContext().getString(R.string.events);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
