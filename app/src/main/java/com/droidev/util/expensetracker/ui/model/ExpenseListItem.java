package com.droidev.util.expensetracker.ui.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shajeer on 24/2/16.
 */
public class ExpenseListItem implements ListItems {

    @SerializedName("userImageUrl")
    private String mUserImageUrl;

    @SerializedName("expenseName")
    private String mExpenseName;

    @SerializedName("expenseDescription")
    private String mExpenseDesc;

    @SerializedName("expenseAmount")
    private float mExpenseAmt;

    public ExpenseListItem(String mExpenseName, String mExpenseDesc, float mExpenseAmt) {
        this.mExpenseName = mExpenseName;
        this.mExpenseDesc = mExpenseDesc;
        this.mExpenseAmt = mExpenseAmt;
    }

    public ExpenseListItem() {
    }

    public float getmExpenseAmt() {
        return mExpenseAmt;
    }

    public void setmExpenseAmt(float mExpenseAmt) {
        this.mExpenseAmt = mExpenseAmt;
    }

    public String getExpenseDesc() {
        return mExpenseDesc;
    }

    public void setExpenseDesc(String mExpenseDesc) {
        this.mExpenseDesc = mExpenseDesc;
    }

    public String getExpenseName() {
        return mExpenseName;
    }

    public void setExpenseName(String mExpenseName) {
        this.mExpenseName = mExpenseName;
    }

    public String getUserImageUrl() {
        return mUserImageUrl;
    }

    public void setUserImageUrl(String mUserImageUrl) {
        this.mUserImageUrl = mUserImageUrl;
    }

    @Override
    public int getType() {
        return EXPENSE_LIST_ITEM;
    }
}
