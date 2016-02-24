package com.droidev.util.expensetracker.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shajeer on 24/2/16.
 */
public class Expense extends GenericResponse{

    @SerializedName("spentUser")
    private String mSpentUser;

    @SerializedName("spendName")
    private String mSpendName;

    @SerializedName("spendDescription")
    private String mSpendDesc;

    public String getSpendDesc() {
        return mSpendDesc;
    }

    public void setSpendDesc(String mSpendDesc) {
        this.mSpendDesc = mSpendDesc;
    }

    public String getSpendName() {
        return mSpendName;
    }

    public void setSpendName(String mSpendName) {
        this.mSpendName = mSpendName;
    }

    public String getSpentUser() {
        return mSpentUser;
    }

    public void setSpentUser(String mSpentUser) {
        this.mSpentUser = mSpentUser;
    }
}
