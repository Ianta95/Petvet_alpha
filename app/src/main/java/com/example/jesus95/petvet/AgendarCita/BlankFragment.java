package com.example.jesus95.petvet.AgendarCita;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jesus95.petvet.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements OnDateSelectedListener {
    Button btnDatePicker, btnTimePicker, btnSaveEvent;
    EditText txtDate, txtTime;
    CalendarDay fechaseleccionada = new CalendarDay();
    private TextView textofecha;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        final Calendar c = Calendar.getInstance();

        MaterialCalendarView calendarView = (MaterialCalendarView) view.findViewById(R.id.calendar);
        textofecha = (TextView) view.findViewById(R.id.txt_fecha_seleccionada);


        textofecha.setText("" + fechaseleccionada);

        calendarView.setOnDateChangedListener(this);
        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        Log.e("My log", "Fecha: " + date);
        fechaseleccionada = date;
        textofecha.setText(fechaseleccionada.getDay() + "/" + fechaseleccionada.getMonth() + "/" + fechaseleccionada.getYear());
    }

}
