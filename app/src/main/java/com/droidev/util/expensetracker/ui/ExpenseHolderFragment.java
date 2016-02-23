package com.droidev.util.expensetracker.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidev.util.expensetracker.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ExpenseHolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpenseHolderFragment extends Fragment {
    public static ExpenseHolderFragment newInstance(String param1, String param2) {
        ExpenseHolderFragment fragment = new ExpenseHolderFragment();
        return fragment;
    }

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense_holder, container, false);
    }
}
