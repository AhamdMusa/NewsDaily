package com.brainybrains.newsdaily;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.Serializable;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    private EditText type;
    private DatePicker from,to;
    private Button news;
    private DatePickerDialog.OnDateSetListener dateAddExpense;
    private String dateFrom,dateTo;
    String typed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        type=findViewById(R.id.type);
        from=findViewById(R.id.fromDate);
        to=findViewById(R.id.toDate);
        news=findViewById(R.id.newsFeed);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type!=null){
                 typed=type.getText().toString().toLowerCase().trim();
                }
                if (from!=null){
                    Calendar calendaraddExpense=Calendar.getInstance();
                    int year= calendaraddExpense.get(Calendar.YEAR);
                    int month=calendaraddExpense.get(Calendar.MONTH);
                    int day=calendaraddExpense.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog=new DatePickerDialog(Main2Activity.this,dateAddExpense,year,month,day);
                    dialog.show();
                    dateAddExpense =new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dateFrom=year+"-"+month+"-"+dayOfMonth;

                        }
                    };

                }
                if (to!=null){
                    Calendar calendaraddExpense=Calendar.getInstance();
                    int year= calendaraddExpense.get(Calendar.YEAR);
                    int month=calendaraddExpense.get(Calendar.MONTH);
                    int day=calendaraddExpense.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog=new DatePickerDialog(Main2Activity.this,dateAddExpense,year,month,day);
                    dialog.show();
                    dateAddExpense =new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dateTo = year + "-" + month + "-" + dayOfMonth;

                        }
                    };
                }
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
               i.putExtra("type", typed);
               i.putExtra("from", dateFrom);
               i.putExtra("to", dateTo);
                startActivity(i);


            }
        });



    }
}
