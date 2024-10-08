package com.example.grados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Spinner spinnerFrom, spinnerTo;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fahrenheit = findViewById(R.id.explicito1);
        Button celsius = findViewById(R.id.explicito2);
        Button kelvin = findViewById(R.id.explicito3);

        fahrenheit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConverterFahrenheit.class);
            startActivity(intent);
        });

        celsius.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConverterCelsius.class);
            startActivity(intent);
        });

        kelvin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConverterKelvin.class);
            startActivity(intent);
        });
    }
}
