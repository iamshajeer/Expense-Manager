package com.droidev.util.expensetracker.network;

import android.content.Context;

import com.droidev.util.expensetracker.model.GenericResponse;
import com.droidev.util.expensetracker.model.RestError;
import com.droidev.util.expensetracker.model.UserLoginDetails;

import retrofit.Callback;
import retrofit.client.Response;


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

    public void initLogin(UserLoginDetails userLoginDetails, final ResponseCallback<GenericResponse>
            responseCallback) {
        Callback<GenericResponse> callback = new RestCallback<GenericResponse>() {

            @Override
            public void success(GenericResponse genericResponse, Response response) {
                responseCallback.onSuccess(genericResponse);
            }

            @Override
            public void error(RestError error) {
                responseCallback.onFailure(error);
            }
        };

        mRestClient.getService(RestClient.AUTH_HEADER).startLogin(userLoginDetails, callback);
    }
}
