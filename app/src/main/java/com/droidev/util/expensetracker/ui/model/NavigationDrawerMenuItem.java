package com.droidev.util.expensetracker.ui.model;

/**
 * Created by shajeer on 23/2/16.
 */
public class NavigationDrawerMenuItem implements ListItems {

    private String mMenuName;
    private int mMenuImageId;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getMenuName() {
        return mMenuName;
    }

    public int getMenuImageId() {
        return mMenuImageId;
    }

    public void setmMenuImageId(int mMenuImageId) {
        this.mMenuImageId = mMenuImageId;
    }

    public void setMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }

    @Override
    public int getType() {
        return NAVIGATION_NORMAL_ITEM;
    }
}
