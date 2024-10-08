package com.example.grados;

public class Fahrenheit extends Grados{

    public Fahrenheit(Double valor){
        this.setUnidad("F");
        this.setValor(valor);
    }


    public Fahrenheit parse(Kelvin kelvin){
        return new Fahrenheit(((kelvin.getValor() - 273.15) * 9/5) + 32);
    }

    public Fahrenheit parse(Celcius celcius){
        return new Fahrenheit(celcius.getValor() * 1.8 + 32 );
    }

}
