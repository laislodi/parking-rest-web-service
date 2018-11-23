package com.webservices.start.persistence.model;

public enum Model {

    FORD(1), FIAT(2), WOLKSWAGEM(3), PEUGEOT(4), TOYOTA(5), BMW(6), OUTRA(7);

    public int modelValue;

    Model (int valor) {
        this.modelValue = valor;
    }

}
