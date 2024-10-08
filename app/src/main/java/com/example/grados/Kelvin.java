package com.example.grados;

public class Kelvin extends Grados{

    public Kelvin(double valor){
        this.setValor(valor);
        this.setUnidad("K");
    }

    public Kelvin parse(Celcius celcius){
        return new Kelvin(celcius.getValor() + 273.15);
    }

    public Kelvin parse(Fahrenheit fahrenheit){
        return new Kelvin((fahrenheit.getValor() + 459.67) * 5/9);
    }
}
