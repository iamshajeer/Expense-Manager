package com.droidev.util.expensetracker.utils;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shajeer on 4/1/16.
 */
public class LogUtils {


    public static void LOGD(final String tag, String message) {
        if (Constants.ENABLE_LOG) {
            Log.d(tag, message);
        }
    }

    public static void LOGV(final String tag, String message) {
        if (Constants.ENABLE_LOG) {
            Log.v(tag, message);
        }
    }

    public static void LOGI(final String tag, String message) {
        Log.i(tag, message);
    }

    public static void LOGW(final String tag, String message) {
        Log.w(tag, message);
    }

    public static void LOGE(final String tag, String message) {
        Log.e(tag, message);
    }

    public static void writeToFile(String directoryName, String fileName, String body) throws IOException {
        FileOutputStream fos = null;
        final File dir = new File(directoryName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        final File file = new File(dir, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        fos = new FileOutputStream(file, true);
        fos.write(body.getBytes());
        fos.close();
    }
}
