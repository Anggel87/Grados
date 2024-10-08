package com.example.grados;

public class Celcius extends Grados{

    public Celcius(Double valor){
        this.setUnidad("C");
        this.setValor(valor);
    }

    public Celcius parse(Kelvin kelvin){
        return new Celcius(kelvin.getValor() - 273.15);
    }

    public Celcius parse(Fahrenheit fahrenheit){
        return  new Celcius((fahrenheit.getValor() - 32) * 5/9);
    }
}