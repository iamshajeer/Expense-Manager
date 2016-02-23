package com.droidev.util.expensetracker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by shajeer on 23/2/16.
 */
public class NetworkUtil {

    /**
     * Checking for all possible Internet providers
     * **/

    public static Boolean isNetworkAvailable(Context context) {

        Boolean isConnected = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null) {
                for (int index = 0; index < networkInfo.length; index++) {
                    if (networkInfo[index].isConnected()) {
                        isConnected = true;
                        break;
                    }
                }
            }
        }
        return isConnected;
    }
}
