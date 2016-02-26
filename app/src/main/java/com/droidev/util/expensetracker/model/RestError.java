package com.droidev.util.expensetracker.model;

/**
 * Created by ekta on 26/2/16.
 */
public class RestError {

    private int mErrorCode;
    private boolean mStatus;
    private String mMessage;

    public int getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(int mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public boolean isStatus() {
        return mStatus;
    }

    public void setStatus(boolean mStatus) {
        this.mStatus = mStatus;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
