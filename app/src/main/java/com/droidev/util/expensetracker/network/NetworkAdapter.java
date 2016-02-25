package com.droidev.util.expensetracker.network;

import android.content.Context;

/**
 * Created by shajeer on 25/2/16.
 */
public class NetworkAdapter {

    private static NetworkAdapter sNetworkAdapter;
    private RestClient mRestClient;

    private NetworkAdapter(Context context) {
        mRestClient = new RestClient(context);
    }

    public static NetworkAdapter get(Context context) {

        if (sNetworkAdapter == null) {
            sNetworkAdapter = new NetworkAdapter(context);
        }
        return sNetworkAdapter;
    }
}
