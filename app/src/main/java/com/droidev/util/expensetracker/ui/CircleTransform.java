package com.droidev.util.expensetracker.ui;

import android.graphics.*;
import com.droidev.util.expensetracker.utils.LogUtils;
import com.squareup.picasso.Transformation;

/**
 * Created by shajeer on 24/2/16.
 */
public class CircleTransform implements Transformation {
    private static final String TAG = CircleTransform.class.getSimpleName();

    @Override
    public Bitmap transform(Bitmap source) {
        return createCenterInsideCircleTransform(source);
    }

    @Override
    public String key() {
        return "circle";
    }

    private Bitmap createCenterInsideCircleTransform(Bitmap source) {
        int size = Math.max(source.getWidth(), source.getHeight());
        Bitmap squaredBitmap = createCenterInsideSquaredBitmap(source);
        if (squaredBitmap == null) return source;
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        if (bitmap == null) return squaredBitmap;
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    private Bitmap createCenterInsideSquaredBitmap(Bitmap srcBmp) {
        if (srcBmp == null) return srcBmp;
        int size = Math.max(srcBmp.getWidth(), srcBmp.getHeight());
        if (size <= 0) return srcBmp;
        int x = (size - srcBmp.getWidth()) / 2;
        int y = (size - srcBmp.getHeight()) / 2;
        Bitmap dstBmp = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBmp);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(srcBmp, x, y, null);
        return dstBmp;
    }

    private Bitmap createCenterCropCircleTransform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }
}