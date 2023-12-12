package br.com.fiap.imposto.model;

import java.util.Observable;

public class Pis extends Observable implements Imposto {

    final float Aliquota = 0.65f;
    float valorDoPis = 0;

    public Pis() {
        System.out.println("Construtor do Model chamado");
    }

    public float getAliquota() {
        return Aliquota;
    }

    public float getValorDoPis() {
        return valorDoPis;
    }

    public void calcularImposto(float valor) {
        valorDoPis = valor * Aliquota;
        setChanged();
        notifyObservers(valorDoPis);
    }

    @Override
    public String toString() {
        return "Pis [Aliquota=" + Aliquota + ", valorDoPis=" + valorDoPis + "]";
    }
}
