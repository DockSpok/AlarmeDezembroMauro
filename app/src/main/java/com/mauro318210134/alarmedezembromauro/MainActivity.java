package com.mauro318210134.alarmedezembromauro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    protected CheckBox checkBoxDom, checkBoxSeg, checkBoxTer, checkBoxQua, checkBoxQui, checkBoxSex, checkBoxSab;
    protected Button btnAgendar;
    protected EditText edtHora;
    protected Calendar calendar;
    protected SharedPreferences sharedPreferences;
    private PendingIntent alarmIntent;
    private AlarmManager alarmManagerDom, alarmManagerSeg, alarmManagerTer, alarmManagerQua, alarmManagerQui, alarmManagerSex, alarmManagerSab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxDom = findViewById(R.id.checkBoxDom);
        checkBoxSeg = findViewById(R.id.checkBoxSeg);
        checkBoxTer = findViewById(R.id.checkBoxTer);
        checkBoxQua = findViewById(R.id.checkBoxQua);
        checkBoxQui = findViewById(R.id.checkBoxQui);
        checkBoxSex = findViewById(R.id.checkBoxSex);
        checkBoxSab = findViewById(R.id.checkBoxSab);

        btnAgendar = findViewById(R.id.btnAgendar);
        edtHora = findViewById(R.id.edtHora);

        calendar = Calendar.getInstance();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        alarmManagerDom = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerSeg = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerTer = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerQua= (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerQui = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerSex = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManagerSab = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarAlarme(calendar);
            }
        });
    }

    private void configurarAlarme(Calendar calendar){
        selecionarDias(calendar);
    }

    private void selecionarDias(Calendar calendar){
        if(checkBoxDom.isChecked())
            alarmManagerDom.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxSeg.isChecked())
            alarmManagerSeg.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxTer.isChecked())
            alarmManagerTer.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxQua.isChecked())
            alarmManagerQua.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxQui.isChecked())
            alarmManagerQui.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxSex.isChecked())
            alarmManagerSex.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        if(checkBoxSab.isChecked())
            alarmManagerSab.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
    }
}