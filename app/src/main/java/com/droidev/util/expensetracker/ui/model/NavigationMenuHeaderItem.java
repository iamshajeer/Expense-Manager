package com.droidev.util.expensetracker.ui.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shajeer on 23/2/16.
 */
public class NavigationMenuHeaderItem implements ListItems {

    @SerializedName("userName")
    private String mUserName;

    @SerializedName("userEmail")
    private String mUserEmail;

    @SerializedName("userImage")
    private String mUserImage;

    public String getmUserEmail() {
        return mUserEmail;
    }

    public String getmUserImage() {
        return mUserImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    @Override
    public int getType() {
        return NAVIGATION_HEADER_ITEM;
    }
}
