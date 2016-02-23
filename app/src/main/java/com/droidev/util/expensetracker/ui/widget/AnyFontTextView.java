package com.droidev.util.expensetracker.ui.widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.manager.FontManager;
import com.droidev.util.expensetracker.utils.LogUtils;

/**
 * Created by shajeer on 4/1/16.
 */
public class AnyFontTextView extends TextView {
    private static final String TAG = AnyFontTextView.class.getSimpleName();

    public AnyFontTextView(Context context) {
        this(context, null);
    }

    public AnyFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnyFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AnyFontTextView);

        if (ta != null) {
            String fontAsset = ta.getString(R.styleable.AnyFontTextView_typefaceAsset);

            if (!TextUtils.isEmpty(fontAsset)) {
                Typeface tf = FontManager.getInstance(context).getFont(fontAsset);
                int style = Typeface.NORMAL;
                float size = getTextSize();

                if (getTypeface() != null) {
                    style = getTypeface().getStyle();
                }
                if (tf != null) {
                    setTypeface(tf, style);
                } else {
                    LogUtils.LOGD(TAG, String.format("Could not create a font from asset: %s",
                            fontAsset));
                }

            }
        }
        setLineSpacing(3, 1);
    }
}
