package com.droidev.util.expensetracker.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.Window;
import com.droidev.util.expensetracker.R;

/**
 * Created by shajeer on 24/2/16.
 */
public class BaseDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        return dialog;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    protected int getDeviceWidth() {
        int deviceWidth;
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        deviceWidth = point.x;
        return deviceWidth;
    }

    @Override
    public void onResume() {
        getDialog().getWindow().setLayout((int) (getDeviceWidth() * .99), getDialog().getWindow()
                .getAttributes().height);
        super.onResume();
    }
}
