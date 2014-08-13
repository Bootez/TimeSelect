package com.example.timeselect;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
    private DatePicker date;
    private TimePicker time;
    private TextView showTime;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        date = (DatePicker)findViewById(R.id.datePicker);
        time = (TimePicker)findViewById(R.id.timePicker);
        showTime = (TextView)findViewById(R.id.showTime);
        
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        
        date.init(year, month, day, new OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                    int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month = monthOfYear;
                MainActivity.this.day = dayOfMonth;
                showTime.setText(hour + ":" + minute + "/" + month + "/" + day + "/" + year);
            }
        });
        
        time.setOnTimeChangedListener(new OnTimeChangedListener() {
            
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute = minute;
                showTime.setText(hour + ":" + minute + "/" + month + "/" + day + "/" + year);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
