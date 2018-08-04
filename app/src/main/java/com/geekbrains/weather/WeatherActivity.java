package com.geekbrains.weather;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = String.valueOf(R.string.first_start);
    //методы жизненного цикла
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);

        Toolbar toolbar = findViewById(R.id.toolbar); //реализуем туллбар
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        String instanceState;
        if (savedInstanceState == null) {
            instanceState =  getResources().getString(R.string.first_start);
        }
        else {
            instanceState = getResources().getString(R.string.restart);
        }
        Toast.makeText(getApplicationContext(), instanceState + " - " + getResources().getString(R.string.onCreate), Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.TAG), getResources().getString(R.string.onCreate));
    }
//методы жизненного цикла
    @Override
    protected void onStart() {
        super.onStart();
       toastAndLog(R.string.onStart);
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.restart) + " - " + getResources().getString(R.string.onRestoreInstanceState), Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.TAG), getResources().getString(R.string.onRestoreInstanceState));
    }

    @Override
    protected void onPause() {
        super.onPause();
       toastAndLog(R.string.onPause);
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
       toastAndLog(R.string.onSaveInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
      toastAndLog(R.string.onResume);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       toastAndLog(R.string.onRestart);
    }

    @Override
    protected void onStop() {
        super.onStop();
        toastAndLog(R.string.onStop);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toastAndLog(R.string.onDestroy);
    }
    public void toastAndLog(int resources){
        Toast.makeText(getApplicationContext(), getResources().getString(resources), Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.TAG), getResources().getString(resources));
    }
}
