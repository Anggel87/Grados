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

public class ConverterKelvin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_converter_kelvin);

        EditText farenheit = findViewById(R.id.farenheit);
        EditText celsius = findViewById(R.id.celsius);
        TextView kelFar = findViewById(R.id.kelvinFarenheit);
        TextView kelCel = findViewById(R.id.kelvinCelsius);
        Button resultado = findViewById(R.id.boton);

        resultado.setOnClickListener(v -> {
            String fareheitText = farenheit.getText().toString();
            String celsiusText = celsius.getText().toString();

            if (!fareheitText.isEmpty()) {
                try {
                    double farenheitNumero = Double.parseDouble(fareheitText);

                    Fahrenheit farenObj = new Fahrenheit(farenheitNumero);
                    Kelvin kelvinObj = new Kelvin(farenheitNumero);

                    kelvinObj = kelvinObj.parse(farenObj);


                    kelFar.setText(kelvinObj.getValor() + " " + kelvinObj.getUnidad());


                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Ingrese un valor valido en Farenheit", Toast.LENGTH_SHORT).show();
                }
            }

            if(!celsiusText.isEmpty()){
                double celsiusNumero = Double.parseDouble(celsiusText);



                Celcius celsiusObj = new Celcius(celsiusNumero);
                Kelvin kelvinObj = new Kelvin(celsiusNumero);
                kelvinObj = kelvinObj.parse(celsiusObj);

                kelCel.setText(kelvinObj.getValor() + " " + kelvinObj.getUnidad());
            }

            if(celsiusText.isEmpty() & fareheitText.isEmpty()){
                Toast.makeText(getApplicationContext(), "Ingrese un valor", Toast.LENGTH_SHORT).show();
            }
        });

    }
}