package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.ToolbarFragment;

public class HomeFragment extends ToolbarFragment {
    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        manageAddExpenseButton(view);
        handleToolbar(view);
        return view;
    }

    private void handleToolbar(View view) {
        initToolbar(view);
        String screenTitle = getString(R.string.home);
        setToolbarTitle(screenTitle, view);
    }

    private void manageAddExpenseButton(View view) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AddExpenseDialog dialog = AddExpenseDialog.getInstance();
                    dialog.show(getFragmentManager(), "TAG");
                }catch (IllegalStateException ise) {
                    ise.printStackTrace();
                }
            }
        });
    }
}
