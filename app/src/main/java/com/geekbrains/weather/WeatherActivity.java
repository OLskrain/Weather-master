package com.geekbrains.weather;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
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
            instanceState =  String.valueOf(R.string.first_start);
            System.out.println(instanceState);
        }
        else {
            instanceState = String.valueOf(R.string.restart);
            System.out.println(instanceState);
        }
        Toast.makeText(getApplicationContext(), instanceState + " - " + R.string.onCreate, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }
//методы жизненного цикла
    @Override
    protected void onStart() {
        super.onStart();
        //Попытался забить весь текст в ресурсы. однако оказалось, что в Log.d(String.valueOf(R.string.TAG), String.valueOf(R.string.onStart);
        //в Logcat прописывает int значения ресурсов R.string.onStart и R.string.TAG вместо текста. пока вернулся к старому варианту.
        //в Toast.makeText(getApplicationContext(), R.string.onStart, Toast.LENGTH_SHORT).show(); и во всех метадах, кроме onCreate
        //на экран эмулятора выводит "onStart" или другие значения соответственно. НО в методе onCreate выводит только int значения.
        //Из-за этого не могу понять почему так по разному выводит. Предположение только одно. когда 2-ой параметр в Toast.makeText не
        //составной, то он выводит текст, а когда составной, как в методе onCreate, то выводит int значения, вместо текста.
        //отправляю как есть. Может подскажите как правильно организовать в таком случае код. или есть методы какие
        Toast.makeText(getApplicationContext(), R.string.onStart, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        //тут специально оставил "Повторный запуск! - onRestoreInstanceState()" для проверки. если заменить, то тоже будет выводить int значения
        Toast.makeText(getApplicationContext(), "Повторный запуск! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //тут и дальше выводит R.string.onPause в виде текста а не int
        Toast.makeText(getApplicationContext(), R.string.onPause, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), R.string.onSaveInstanceState, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), R.string.onResume, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), R.string.onRestart, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), R.string.onStop, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), R.string.onDestroy, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }
}
