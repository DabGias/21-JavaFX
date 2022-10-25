package com.example.classes;

public class Computador extends Jogador {
    @Override
    public void setParou(boolean parou) {
        if (this.getPontos() > 16) {
            super.setParou(parou);
        }
    }
}