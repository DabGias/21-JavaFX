package com.example.classes;

public class Carta {
    private int numero;
    private Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath() {
        if (this.numero == 11) {
            return "classic-cards/Ace" + this.naipe + ".png"; 
        } else if (this.numero == 10) {
            return "classic-cards/King" + this.naipe + ".png";
        } else if (this.numero == 12) {
            return "classic-cards/Queen" + this.naipe + ".png";
        } else if (this.numero == 13) {
            return "classic-cards/Jack" + this.naipe + ".png";
        }

        return "classic-cards/" + this.numero + this.naipe + ".png";
    }

    public int getNumero() {
        return numero;
    } 

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }
}
