package com.example.demo_meet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class library_management extends AppCompatActivity {

    private TextView duedate;
    private TextView todaydate;
    private TextView penaltyamt;
    private Date date1, date2;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_management);


            duedate = findViewById(R.id.duedatedatepicker);
            TextView findpenalty = findViewById(R.id.findduebtn);
            todaydate = findViewById(R.id.todaydate);
            penaltyamt = findViewById(R.id.penalty);
            Calendar myCalendar = Calendar.getInstance();

            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String formattedDate = df.format(c);
            try {
                date2 = df.parse(formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                try {
                    date1 = sdf.parse(sdf.format(myCalendar.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                duedate.setText(sdf.format(myCalendar.getTime()));

                todaydate.setText("Today's Date : " + formattedDate);
                Toast.makeText(library_management.this, "Penalty per day = Rs.20", Toast.LENGTH_SHORT).show();
            };
            duedate.setOnClickListener(v -> new DatePickerDialog(library_management.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show());

            findpenalty.setOnClickListener(v -> {
                if (duedate.getText().toString().equals("Select Due Date")) {
                    Toast.makeText(library_management.this, "Please Enter Due Date", Toast.LENGTH_SHORT).show();
                } else {
                    long diff = date2.getTime() - date1.getTime();
                    long seconds = diff / 1000;
                    long minutes = seconds / 60;
                    long hours = minutes / 60;
                    long days = (hours / 24) + 1;
                    penaltyamt.setVisibility(View.VISIBLE);
                    penaltyamt.setText("Penalty : " + days * 20);
                }
            });
        }
    }