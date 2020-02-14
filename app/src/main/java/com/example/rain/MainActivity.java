package com.example.rain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.graphics.Color.*;
import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    private Button showTag,showMoney;
    private TextView moneyText;

    private int moneyCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMoney = findViewById(R.id.button_money_rain);
        showTag = findViewById(R.id.button_showTag);
        moneyText = findViewById(R.id.money);

    }

    public void makeItRain(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyText.setText(String.valueOf(numberFormat.format(moneyCounter)));
        limitMoney(moneyCounter);
    }
    public void showTag(View v) {
        Toast.makeText(getApplicationContext(),R.string.fun,Toast.LENGTH_LONG)
                .show();
    }
    public void reset(View view) {
        moneyText.setText("£0");
        moneyText.setTextColor(WHITE);
        moneyCounter = 0;
    }

   public void limitMoney(int moneyCounter) {
       switch (moneyCounter) {
           case 10000:
               moneyText.setTextColor(BLACK);
               break;
           case 20000:
               moneyText.setTextColor(RED);
               break;
           case 30000:
               moneyText.setTextColor(GREEN);
               break;
           case 40000:
               moneyText.setTextColor(GRAY);
               break;
           default:
               break;
       }
   }




}
