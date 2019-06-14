package android.example.hw_fragment_passdata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> myFragmentList =new ArrayList<>();
    private List<String> myTitleList=new ArrayList<>();


    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return myFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title){
        myFragmentList.add(fragment);
        myTitleList.add(title);
    }

    public CharSequence getPageTitle(int position){
        return myTitleList.get(position);
    }
}
