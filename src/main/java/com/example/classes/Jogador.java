package com.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int pontos = 0;
    private List<Carta> cartas = new ArrayList<Carta>();
    private boolean parou = false;

    public Jogador() {
        
    }

    public void receberCarta(Carta carta) {
        if (carta.getNumero() == 10 || carta.getNumero() == 12 || carta.getNumero() == 13) {
            setPontos(this.pontos + 10);
        } else {
            setPontos(this.pontos + carta.getNumero());
        }

        cartas.add(carta);
    }

    public void parar() {
        setParou(true);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public boolean isParou() {
        return parou;
    }

    public void setParou(boolean parou) {
        this.parou = parou;
    }    
}
