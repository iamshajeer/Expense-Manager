package com.droidev.util.expensetracker.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shajeer on 23/2/16.
 */
public class FileUtils {

    /**
     * loading json file from assets directory
     *
     * @param context  calling context
     * @param fileName name of the file to read
     * @return file as string
     */
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
