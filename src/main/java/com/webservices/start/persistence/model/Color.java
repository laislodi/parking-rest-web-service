package com.webservices.start.persistence.model;

public enum Color {
    PRETO(1), PRATA(2), BRANCO(3), VERMELHO(4), AMARELO(5), ROSA(6), OUTRA(7);

    int colorValue;

    Color(int valor) {
        this.colorValue = valor;
    }
}
