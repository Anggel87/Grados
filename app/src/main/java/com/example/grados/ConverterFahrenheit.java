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

public class ConverterFahrenheit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_converter_fahrenheit);

        // Asignar elementos de la interfaz
        EditText celsius = findViewById(R.id.celsius);
        EditText kelvin = findViewById(R.id.kelvin);
        TextView fareCel = findViewById(R.id.farenheitCelsius);
        TextView farKel = findViewById(R.id.farenheitKelvin2);
        Button resultado = findViewById(R.id.boton);

        resultado.setOnClickListener(v -> {
            String celsiusText = celsius.getText().toString();
            String kelvinText = kelvin.getText().toString();

            if (!celsiusText.isEmpty()) {
                try {
                    double celsiusNumero = Double.parseDouble(celsiusText);

                    Celcius celsiusToFaren = new Celcius(celsiusNumero);
                    Fahrenheit farenToCel = new Fahrenheit(celsiusNumero);

                    farenToCel = farenToCel.parse(celsiusToFaren);

                    farenToCel.parse(celsiusToFaren);

                    fareCel.setText(farenToCel.getValor() + " " + farenToCel.getUnidad());


                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Ingrese un valor valido en Celsius", Toast.LENGTH_SHORT).show();
                }
            }

            if(!kelvinText.isEmpty()){
                double kelvinNumero = Double.parseDouble(kelvinText);

                Kelvin kelvinToFar = new Kelvin(kelvinNumero);

                Fahrenheit farenToKel = new Fahrenheit(kelvinNumero);
                farenToKel = farenToKel.parse(kelvinToFar);

                farKel.setText(farenToKel.getValor() + " " + farenToKel.getUnidad());
            }

            if(kelvinText.isEmpty() & celsiusText.isEmpty()){
                Toast.makeText(getApplicationContext(), "Ingrese un valor", Toast.LENGTH_SHORT).show();
            }
        });

    }
}