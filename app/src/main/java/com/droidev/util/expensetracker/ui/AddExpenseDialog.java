package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.droidev.util.expensetracker.R;

/**
 * Created by shajeer on 24/2/16.
 */
public class AddExpenseDialog extends BaseDialogFragment {

    private static AddExpenseDialog sInstance = new AddExpenseDialog();

    /**
     * call getInstance method to
     */
    public AddExpenseDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.add_expense_dlg, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }

    public static AddExpenseDialog getInstance() {
        return sInstance;
    }
}
