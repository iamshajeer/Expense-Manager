package com.droidev.util.expensetracker.ui.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shajeer on 23/2/16.
 */
public class NavigationDrawerMenuItem implements ListItems {

    @SerializedName("menuName")
    private String mMenuName;

    @SerializedName("menuImageUrl")
    private String mMenuImageUrl;

    public String getMenuImageUrl() {
        return mMenuImageUrl;
    }

    public String getMenuName() {
        return mMenuName;
    }


    public void setMenuImageUrl(String mMenuImageUrl) {
        this.mMenuImageUrl = mMenuImageUrl;
    }

    public void setMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }

    @Override
    public int getType() {
        return NAVIGATION_NORMAL_ITEM;
    }
}
