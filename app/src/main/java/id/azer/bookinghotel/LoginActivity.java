package id.azer.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

import chanphenghor.com.library.EditTextIconLeft;
import id.azer.bookinghotel.nitip.AlertReceiver;
import id.azer.bookinghotel.nitip.TimePickerFragment;
import id.azer.bookinghotel.nitip2.DailyReceiver;
import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    EditTextIconLeft edtEmail;
    EditTextIconLeft edtPass;
    FancyButton btnLoginFB;
    FancyButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLoginFB = findViewById(R.id.btnLoginFB);
        btnLogin = findViewById(R.id.btnLogin);

        EdtLogin();
        btnLoginFB();
        btnLogin();

    }

    private void EdtLogin(){
        edtEmail.setBorderFocus(
                R.drawable.border_edittext,
                R.drawable.focus_border,
                R.drawable.user_empty,
                R.drawable.user_empty_focus);
        edtEmail.editText().requestFocus();
        edtEmail.iconLeft().setVisibility(View.VISIBLE);

        edtPass.setBorderFocus(
                R.drawable.border_edittext,
                R.drawable.focus_border,
                R.drawable.user_empty,
                R.drawable.user_empty_focus);
        edtPass.editText().requestFocus();
        edtPass.iconLeft().setVisibility(View.VISIBLE);
    }

    private void btnLoginFB(){
        btnLoginFB.setText("Login with Facebook");
        btnLoginFB.setBackgroundColor(Color.parseColor("#3b5998"));
        btnLoginFB.setFocusBackgroundColor(Color.parseColor("#5474b8"));
        btnLoginFB.setTextSize(17);
        btnLoginFB.setRadius(5);
        btnLoginFB.setIconResource("\uf082");
        btnLoginFB.setIconPosition(FancyButton.POSITION_LEFT);
        btnLoginFB.setFontIconSize(30);

        btnLoginFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });
    }

    private void btnLogin(){
        btnLogin.setText("Login");
        btnLogin.setBackgroundColor(Color.parseColor("#000000"));
        btnLogin.setFocusBackgroundColor(Color.parseColor("#5474b8"));
        btnLogin.setTextSize(17);
        btnLogin.setRadius(5);
        btnLogin.setIconResource("");
        btnLogin.setIconPosition(FancyButton.POSITION_LEFT);
        btnLogin.setFontIconSize(30);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();*/

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

//Tutor Time 1
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        updateTimeText(c);
        startAlarm(c);
    }
    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
    }
    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }
    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.cancel(pendingIntent);
    }

//Tutor Time2
public void setAlarm() {
    // Quote in Morning at 08:32:00 AM
    Calendar calendar = Calendar.getInstance();

    calendar.set(Calendar.HOUR_OF_DAY, 9);
    calendar.set(Calendar.MINUTE, 23);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    Calendar cur = Calendar.getInstance();

    if (cur.after(calendar)) {
        calendar.add(Calendar.DATE, 1);
    }

    Intent myIntent = new Intent(this, DailyReceiver.class);
    int ALARM1_ID = 10000;
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            this, ALARM1_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }
}