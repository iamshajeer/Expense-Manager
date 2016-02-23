package com.droidev.util.expensetracker.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.widget.ViewPagerCustomDuration;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class ExpenseHolderFragment extends Fragment {
    private ViewPagerCustomDuration mSliderViewPager;

    public ExpenseHolderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expense_holder, container, false);
        initUI(view);
        //showSlidingLayout();
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
