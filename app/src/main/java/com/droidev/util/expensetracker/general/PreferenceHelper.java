package com.droidev.util.expensetracker.general;

import android.content.Context;
import android.content.SharedPreferences;
import com.droidev.util.expensetracker.utils.Constants;

/**
 * Created by shajeer on 24/2/16.
 */
public class PreferenceHelper {

    private static final String PREF_NAME = "expns_mgr_pref";
    private static final String TAG = PreferenceHelper.class.getSimpleName();

    /**
     * reads string value of preference based on the key
     *
     * @param context calling context
     * @param key     preference key
     * @return value corresponding to given key
     */
    public static String getPrefString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    /**
     * stores string value to preference based on the key
     *
     * @param context calling context
     * @param key     preference key
     * @param value   value to store
     * @return value corresponding to given key
     */
    public static void storePrefString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * reads integer value of preference based on the key
     *
     * @param context calling context
     * @param key     preference key
     * @return value corresponding to given key
     */
    public static int getPrefInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, 0);
    }

    /**
     * stores integer value to preference based on the key
     *
     * @param context calling context
     * @param key     preference key
     * @param value   value to store
     * @return value corresponding to given key
     */
    public static void storePrefInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static Boolean getPrefBool(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void storePrefBool(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static long getPrefLong(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, 0);
    }

    public static void storePrefLong(Context context, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static boolean containsKey(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        if (sp.contains(key)) {
            return true;
        }
        return false;
    }

    public static void removeKeyFromPreference(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        if (sp.contains(key)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(key);
            editor.apply();
        }
    }

    /**
     * reads user name from preference
     *
     * @param context calling context
     * @return user name
     */
    public static String getUserName(Context context) {
        return getPrefString(context, Constants.UserPreferences.PREF_USR_NAME);
    }

    /**
     * reads user email id from preference
     *
     * @param context calling context
     * @return user email id
     */
    public static String getUserEmail(Context context) {
        return getPrefString(context, Constants.UserPreferences.PREF_USR_EMAIL);
    }
}
