package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.droidev.util.expensetracker.R;

public class ToolbarFragment extends Fragment {

    private AttachToolbar mAttachToolbar;

    public void setAttachToolbar(AttachToolbar attachToolbar) {
        mAttachToolbar = attachToolbar;
    }

    protected void sendToolbar(Toolbar toolbar) {
        if (mAttachToolbar != null) {
            mAttachToolbar.onAttachToolbar(toolbar);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    protected void initToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar == null) return;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        getActionBar().setDisplayShowTitleEnabled(false);
        sendToolbar(toolbar);
    }

    protected void enableToolbarBackButton(boolean show) {
        getActionBar().setDisplayHomeAsUpEnabled(show);
        getActionBar().setDisplayShowHomeEnabled(show);
    }

    protected void setToolbarTitle(String title, View view) {
        TextView titleView = (TextView) view.findViewById(R.id.toolbar_title);
        titleView.setText(title);
    }

    protected void setToolbarLogo(int resId, View view) {
        getActionBar().setDisplayShowTitleEnabled(false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setLogo(resId);
    }

    public interface AttachToolbar {
        void onAttachToolbar(Toolbar toolbar);
    }
}