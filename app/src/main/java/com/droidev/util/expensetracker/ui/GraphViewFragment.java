package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.droidev.util.expensetracker.R;

public class GraphViewFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int mParam1;

    public static GraphViewFragment newInstance(int position) {
        GraphViewFragment fragment = new GraphViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public GraphViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph_view, container, false);
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        TextView tv = (TextView) view.findViewById(R.id.tv_hint);
        tv.setText(mParam1+"");
    }

}
