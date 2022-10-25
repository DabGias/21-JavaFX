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
            // TODO: Arrumar essa bagaça doida que eu não sei como vou retornar a carta certa
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
