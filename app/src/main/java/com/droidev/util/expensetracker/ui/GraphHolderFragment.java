package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.widget.ViewPagerCustomDuration;

import java.util.Timer;
import java.util.TimerTask;

public class GraphHolderFragment extends Fragment {

    private ViewPagerCustomDuration mSliderViewPager;
    private Timer mSwipeTimer;

    public GraphHolderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        initUI(view);
        showSlidingLayout();
        return view;
    }

    private void initUI(View view) {
        mSliderViewPager = (ViewPagerCustomDuration) view.findViewById(R.id
                .graph_view_pager);
    }

    private void showSlidingLayout() {
        GraphViewPagerAdapter adapter = new GraphViewPagerAdapter
                (getActivity().getSupportFragmentManager());
        mSliderViewPager.setAdapter(adapter);
        mSliderViewPager.setOffscreenPageLimit(10);
        mSliderViewPager.setScrollDurationFactor(3);
    }


    private class GraphViewPagerAdapter extends FragmentStatePagerAdapter {
        private static final int MAX_PAGES = 4;

        public GraphViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            GraphViewFragment fragment = GraphViewFragment.newInstance(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGES;
        }
    }
}