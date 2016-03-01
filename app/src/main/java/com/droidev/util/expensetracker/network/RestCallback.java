package com.droidev.util.expensetracker.network;


import com.droidev.util.expensetracker.model.RestError;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ekta on 26/2/16.
 */
public abstract class RestCallback<T> implements Callback<T> {

    public abstract void error(RestError error);

    @Override
    public void success(T t, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {
        RestError restError = new RestError();
//        restError.setErrorCode(error.getResponse().getStatus());
        restError.setMessage(error.getMessage());
        restError.setStatus(false);
        error(restError);
    }
}
