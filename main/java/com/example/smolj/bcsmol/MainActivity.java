package com.example.smolj.bcsmol;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.smolj.bcsmol.Graf.Dijkstra;
import com.example.smolj.bcsmol.Graf.Graph;
import com.example.smolj.bcsmol.Graf.Vrchol;
import com.example.smolj.bcsmol.files.Parser;
import com.example.smolj.bcsmol.files.Zastavky;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static Button btn, staticDateBtn, staticTimeBtn;
    private static TextView tFrom, tTo;
    private static int minutes, hours, day, month, year;

    public void RUN() {
        int time = hours * 100 + minutes;
        Graph g = new Graph();
        Parser p = new Parser();
        p.fieldZastavky();
        ArrayList<Integer> field = new ArrayList<>();
        int temp = 0;

        String sZastavka = "Fatranská";
        String eZastavka = "Slnečné námestie";
        //String sZastavka = getFromText();
        //String eZastavka = getToText();
        int cislosz = 0;
        int cisloez = 0;
        int obmedzenie = 0;
        int zobraz = 1;
        int lessTimeToMove = 2;

        Dijkstra d = new Dijkstra(time, obmedzenie, lessTimeToMove);

        for (Zastavky s : p.getArrayZ()) {
            if (cislosz == s.getNumberZastavky() || (sZastavka.equals(s.getCloseMesto()))) {
                sZastavka = s.getCloseMesto();
                cislosz = s.getNumberZastavky();
            }
            if (cisloez == s.getNumberZastavky() || (eZastavka.equals(s.getCloseMesto()))) {
                eZastavka = s.getCloseMesto();
                cisloez = s.getNumberZastavky();
            }

        }

        Vrchol V = new Vrchol(cislosz, sZastavka);
        Vrchol R = new Vrchol(cisloez, eZastavka);

        for (int a = 0; a < zobraz; a++) {
            for (Integer entry : d.findPath(V, R, time)) {//19
                field.add(entry);
            }
            for (Integer prem : field) {
                if (temp != 0) {
                    d.getIT(temp, prem);
                }
                temp = prem;
            }
            d.show();
            System.out.println(".......................................");
            System.out.println(".......................................");
            System.out.println(".......................................");
            time = d.getTimeContinue();
            d.setCas(d.getTimeContinue() + 1);
        }
    }


    public String getFromText() {
        String from = tFrom.getText().toString();
        return from;
    }

    public String getToText() {
        String to = tTo.getText().toString();
        return to;
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours = hourOfDay;
            minutes = minute;
            staticTimeBtn.setText(hours + ":" + minutes);

        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker_button");
        changetimebutton();
    }

    public static class DatepickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int yearD, int monthD, int dayD) {
            year = yearD;
            month = monthD;
            day = dayD;
            staticDateBtn.setText(day + ":" + month + ":" + year);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatepickerFragment();
        newFragment.show(getFragmentManager(), "date_Picker_button");
        changedatebutton();
    }

    public void changetimebutton() {
        Button button = (Button) findViewById(R.id.timePicker_button);
        button.setText(hours + ":" + minutes);
    }

    public void changedatebutton() {
        Button button = (Button) findViewById(R.id.date_Picker_button);
        button.setText(day + ":" + month + ":" + year);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staticDateBtn = (Button) findViewById(R.id.date_Picker_button);
        staticTimeBtn = (Button) findViewById(R.id.timePicker_button);
        tFrom = (EditText) findViewById(R.id.Bfrom);
        tTo = (EditText) findViewById(R.id.tTo);
        Button searchBtn = (Button) findViewById(R.id.find);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RUN();
            }
        });
    }
}
