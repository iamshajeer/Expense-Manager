package com.droidev.util.expensetracker.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by shajeer on 23/2/16.
 */
public class ToastUtils {
    public static void SHOW(Context context, String message) {
        if (Constants.ENABLE_TOAST) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
