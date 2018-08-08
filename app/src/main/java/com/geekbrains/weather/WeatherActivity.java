package com.geekbrains.weather;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class WeatherActivity extends AppCompatActivity {

    private TextView tv_city;
    private FloatingActionButton buttonFab;
    private Boolean isPressed = false;

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
        //вызываем элемент(кнопку) по id
        buttonFab = findViewById(R.id.buttonFab);
        tv_city = findViewById(R.id.tv_city);

        if(getIntent().getExtras() != null) {
            String text = getIntent().getExtras().getString(getResources().getString(R.string.TEXT)); //получаем значение строки из второй активити
            tv_city.setText(text);
        }

        //слушатель для нашей кнопки
        buttonFab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!isPressed){              //проверка на то, чтобы пользователь не смог запустить случайно несколько активностей
                    isPressed = true;
                    startNewActivity();
                    toastAndLog(R.string.start_new_activity);
                }
            }
        });

        Toasty.success(getApplicationContext(), instanceState + " - " + getResources().getString(R.string.onCreate), Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.TAG), getResources().getString(R.string.onCreate));
    }

    private void startNewActivity(){
        //при старте новой активити передаем компонент старой активити
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
//        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String name = data.getStringExtra(getResources().getString(R.string.TEXT));
        tv_city.setText(name);
        isPressed = false;
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
        Toasty.success(getApplicationContext(), getResources().getString(R.string.restart) + " - " + getResources().getString(R.string.onRestoreInstanceState), Toast.LENGTH_SHORT).show();
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

//    @Override
//    public void onBackPressed() { //метод, который отвечает за переход назад и делает нашу кнопку снова активной
//        super.onBackPressed();
//        isPressed = false;
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toastAndLog(R.string.onDestroy);
    }
    public void toastAndLog(int resources){
        Toasty.success(getApplicationContext(), getResources().getString(resources), Toast.LENGTH_SHORT).show();
        Log.d(getResources().getString(R.string.TAG), getResources().getString(resources));
    }
}
