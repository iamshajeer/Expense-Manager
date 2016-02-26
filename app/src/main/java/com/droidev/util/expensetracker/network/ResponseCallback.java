package com.droidev.util.expensetracker.network;

import com.droidev.util.expensetracker.model.RestError;

/**
 * Created by ekta on 26/2/16.
 */
public interface ResponseCallback<T> {

    void onSuccess(T t);

    void onFailure(RestError error);
}
