package com.example.classes;

public class Computador extends Jogador {
    @Override
    public boolean isParou() {
        if (this.getPontos() > 16) {
            return true;
        }

        return false;
    }
    
}