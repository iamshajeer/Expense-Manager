package com.droidev.util.expensetracker.model;

/**
 * Created by ekta on 26/2/16.
 */
public class UserLoginDetails {

    private String mUserId;
    private String mPassword;
    private String mDeviceId;

    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String mDeviceId) {
        this.mDeviceId = mDeviceId;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String mUserId) {
        this.mUserId = mUserId;
    }
}
