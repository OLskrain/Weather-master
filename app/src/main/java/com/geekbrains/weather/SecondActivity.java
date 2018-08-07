package com.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText et_secondActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        et_secondActivity = findViewById(R.id.et_secondActivity);
    }

    @Override
    //при возврате на первую активность передаем данные из второй активности
    public void onBackPressed() {
        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra(getResources().getString(R.string.TEXT), et_secondActivity.getText().toString().trim()); //передаем значение строки
        startActivity(intent);
        finish();
    }
}
