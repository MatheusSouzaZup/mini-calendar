package com.lerning.zup.calendarview;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lerning.zup.calendarview.component.MiniCalendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiniCalendar miniCalendar = (MiniCalendar) findViewById(R.id.miniCalendar);
        miniCalendar.setUsedDays(getDays());
        miniCalendar.setDate(new GregorianCalendar(2018,1-1,1));

    }

    private List<Integer> getDays() {
        List<Integer> mList = new ArrayList<>();
        mList.add(1);
        mList.add(5);
        mList.add(9);
        mList.add(13);
        mList.add(21);
        return mList;
    }
}
