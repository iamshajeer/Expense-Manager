package com.droidev.util.expensetracker.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shajeer on 24/2/16.
 */
public class GenericResponse {

    @SerializedName("mCode")
    private int mCode;

    @SerializedName("status")
    private boolean mStatus;

    @SerializedName("message")
    private String mMessage;

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public boolean isStatus() {
        return mStatus;
    }
}
