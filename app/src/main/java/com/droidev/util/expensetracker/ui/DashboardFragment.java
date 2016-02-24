package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.droidev.util.expensetracker.R;

public class DashboardFragment extends ToolbarFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        handleToolbar(view);
        return view;
    }

    private void handleToolbar(View view) {
        initToolbar(view);
        setToolbarTitle(getString(R.string.dashboard), view);
        enableToolbarBackButton(true);
    }
}