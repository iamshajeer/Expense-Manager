package com.droidev.util.expensetracker.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ekta on 1/3/16.
 */
public class GeneralUtils {

    public static final String SALT = "NYFFHL3^=Qd6#yCM";

    public static String getSecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            md.update(getSalt().getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static boolean isEmailValid(String emailAddress) {
        Pattern emailPattern = Pattern
                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\" +
                        ".[A-Za-z]{1,})$");

        // Match the given string with the pattern
        Matcher emailMatcher = emailPattern.matcher(emailAddress);

        // check whether match is found
        boolean matchFound = emailMatcher.matches();
        return matchFound;
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        return SALT;
    }

    public static String getDeviceId(Context context) {
        String device_id;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            device_id = tm.getDeviceId();
        } else {
            device_id = Build.SERIAL;
        }

        if (device_id == null) {
            device_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure
                    .ANDROID_ID);
        }

        return device_id;
    }
}
