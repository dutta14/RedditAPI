package anindya.redditapi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by anind on 12/6/2017.
 */

public class SectionAdapter extends FragmentPagerAdapter {
    private final int[] headings = {R.string.hot, R.string.news, R.string.rising, R.string.random};
    private ArrayList<ListFragment> mFragments;
    private int mTotalFrags;
    private Context mContext;

    public SectionAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        mTotalFrags = 4;
        mFragments = new ArrayList<>();
        for(int i=0; i<mTotalFrags; i++) {
            mFragments.add(ListFragment.newInstance(i+1));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(headings[position]);
    }
}
