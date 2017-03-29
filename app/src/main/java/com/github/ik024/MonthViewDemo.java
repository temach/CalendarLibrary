package com.github.ik024;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.ik024.calendar_lib.adapters.EventInfo;
import com.github.ik024.calendar_lib.listeners.MonthViewClickListeners;
import com.github.ik024.calendar_lib.custom.MonthView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthViewDemo extends AppCompatActivity implements MonthViewClickListeners {

    MonthView monthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_view_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MonthViewDemo");

        //getting reference to MonthCalendarView
        monthView = (MonthView) findViewById(R.id.calendar_month_view);

        //registering the click listeners
        monthView.registerClickListener(this);

        //creating list of events
        Map<Date,EventInfo> eventList = getEventList();

        //adding events to the calendar
        monthView.setEventList(eventList);
    }

    @Override
    public void dateClicked(Date dateClicked) {
        //TODO: depending on the date clicked perform your action
        Toast.makeText(this, "date: "+dateClicked.toString(), Toast.LENGTH_LONG).show();
    }

    private Map<Date,EventInfo> getEventList(){
        //generating dummy event list
        Map<Date,EventInfo> eventList = new HashMap<>();
        eventList.put(getDate(2017, 3, 9), new EventInfo(Color.RED, Color.WHITE));
        eventList.put(getDate(2017, 3, 11), new EventInfo(Color.GREEN, Color.WHITE));
        eventList.put(getDate(2017, 3, 13), new EventInfo(Color.BLUE, Color.WHITE));
        eventList.put(getDate(2017, 3, 15), new EventInfo(Color.BLUE, Color.WHITE));

        return eventList;
    }

    private Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
