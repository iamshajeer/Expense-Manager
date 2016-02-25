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
import com.droidev.util.expensetracker.ui.model.ExpenseListItem;
import com.droidev.util.expensetracker.ui.model.ListItems;

import java.util.ArrayList;

public class HomeFragment extends ToolbarFragment implements AddExpenseDialog
        .AddExpenseDialogInteractor {

    ArrayList<ListItems> mExpenseList;

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
                    AddExpenseDialog dialog = AddExpenseDialog.getInstance(HomeFragment.this);
                    dialog.show(getFragmentManager(), "TAG");
                } catch (IllegalStateException ise) {
                    ise.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onSubmitted(String name, String description, float amount) {
        ExpenseListItem item = new ExpenseListItem(name, description,amount);
        mExpenseList.add(item);
    }
}
