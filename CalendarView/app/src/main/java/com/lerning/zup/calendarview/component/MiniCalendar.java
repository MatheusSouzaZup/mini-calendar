package com.lerning.zup.calendarview.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.lerning.zup.calendarview.R;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ZUP on 21/11/2017.
 */

public class MiniCalendar extends View {

    Paint paint;
    private int mRadius;
    private int firstDay;
    private int maxSpace;
    private int space;
    private int x = 40;
    private int y = 40;
    private List<Integer> mUsedDays;
    private int monthSize;

    public MiniCalendar(Context context) {
        super(context);
        init();
    }

    public MiniCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MiniCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MiniCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        firstDay = 1;
        maxSpace = 280;
        space = 40;
        mRadius = pxToDp(5);
    }
    public void setDate(Calendar calendar) {
        firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        monthSize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public float getRadius() {
        return dpToPx(mRadius);

    }
    public int getFirstDay(){
        return firstDay;
    }
    public void setUsedDays(List<Integer> usedDays) {
        mUsedDays = usedDays;
    }

    public List<Integer> getUsedDays() {
        return mUsedDays;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = x * getFirstDay();

        for (Integer i = 1; i <= monthSize; i++) {
            paint.setStyle(Paint.Style.FILL);
            for(Integer d : mUsedDays) {
                if(d.equals(i)) {
                    paint.setColor(Color.WHITE);
                    canvas.drawCircle(x, y, getRadius(), paint);
                    break;
                }
                else {
                    paint.setColor(Color.WHITE);
                    paint.setAlpha(10);
                    canvas.drawCircle(x, y, getRadius(), paint);
                }
            }
            if (x < maxSpace) {
                x += space;
            } else {
                y += space;
                x = space;
            }

        }
        x = space;
        y = space;

    }
}
