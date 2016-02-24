package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.droidev.util.expensetracker.R;

public class SettingsFragment extends ToolbarFragment {

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        handleToolbar(view);
        return view;
    }

    private void handleToolbar(View view) {
        initToolbar(view);
        setToolbarTitle(getString(R.string.settings), view);
        enableToolbarBackButton(true);
    }
}
