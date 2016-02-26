package com.droidev.util.expensetracker.intf;

import com.droidev.util.expensetracker.model.GenericResponse;
import com.droidev.util.expensetracker.model.UserLoginDetails;
import com.droidev.util.expensetracker.model.UserRegistration;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by shajeer on 25/2/16.
 */
public interface ApiService {

    @POST("user/login")
    void startLogin(@Body UserLoginDetails userLoginDetails, Callback<GenericResponse> callback);

    @POST("user/registration")
    void startRegistration(@Body UserRegistration registration, Callback<GenericResponse> callback);

}
