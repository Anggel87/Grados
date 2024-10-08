package com.example.grados;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ConverterCelsius extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_converter_celsius);

        EditText farenheit = findViewById(R.id.farenheit);
        EditText kelvin = findViewById(R.id.kelvin);
        TextView celFar = findViewById(R.id.celsiusFarenheit);
        TextView celKel = findViewById(R.id.celsiusKelvin);
        Button resultado = findViewById(R.id.boton);

        resultado.setOnClickListener(v -> {
            String fareheitText = farenheit.getText().toString();
            String kelvinText = kelvin.getText().toString();

            if (!fareheitText.isEmpty()) {
                try {
                    double farenheitNumero = Double.parseDouble(fareheitText);

                    Fahrenheit farenObj = new Fahrenheit(farenheitNumero);
                    Celcius celsiusObj = new Celcius(farenheitNumero);

                    celsiusObj = celsiusObj.parse(farenObj);


                    celFar.setText(celsiusObj.getValor() + " " + celsiusObj.getUnidad());


                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Ingrese un valor valido en Farenheit", Toast.LENGTH_SHORT).show();
                }
            }

            if(!kelvinText.isEmpty()){
                double kelvinNumero = Double.parseDouble(kelvinText);

                Kelvin kelvinToFar = new Kelvin(kelvinNumero);

                Celcius celToKel = new Celcius(kelvinNumero);
                celToKel = celToKel.parse(kelvinToFar);

                celKel.setText(celToKel.getValor() + " " + celToKel.getUnidad());
            }

            if(kelvinText.isEmpty() & fareheitText.isEmpty()){
                Toast.makeText(getApplicationContext(), "Ingrese un valor", Toast.LENGTH_SHORT).show();
            }
        });

    }
}