package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOrder = (Button) findViewById(R.id.buttonOrder);
        TextView resultTextView = (TextView) findViewById(R.id.resultText);
        RadioGroup radioGroupFilling = (RadioGroup) findViewById(R.id.radioGroupFilling);
        CheckBox checkBoxFry = (CheckBox) findViewById(R.id.checkboxFry);
        Switch switchCutlery = (Switch) findViewById(R.id.switchCutlery);
        ToggleButton togglePay = (ToggleButton) findViewById(R.id.togglePay);

        buttonOrder.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder("Ваш ");

            if (checkBoxFry.isChecked()) {
                result.append(getString(R.string.checkFry)).append(" ");
            }
            result.append("пирожочек ");

            int checkedFilling = radioGroupFilling.getCheckedRadioButtonId();
            switch (checkedFilling) {
                case R.id.radioFillingChery:
                    result.append(getString(R.string.cherryFilling));
                    break;
                case R.id.radioFillingApple:
                    result.append(getString(R.string.appleFilling));
                    break;
                case R.id.radioFillingCurrant:
                    result.append(getString(R.string.currantFilling));
                    break;
                case R.id.radioFillingLemon:
                    result.append(getString(R.string.lemonFilling));
                    break;
                default:
                    break;
            }
            result.append(" уже готовится!\n");

            if (switchCutlery.isChecked()) {
                result.append("Мы положили Вам приборы\n");
            }
            else {
                result.append("Мы не клали вам приборы\n");
            }

            if (togglePay.isChecked()) {
                result.append("Оплатите заказ картой");
            }
            else {
                result.append("Оплатите заказ наличными");
            }

            resultTextView.setText(result.toString());
        });
    }
}