package com.example.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas = new ArrayList<Carta>();

    public Monte() {
        for (int i = 2; i < 14; i++) {
            Carta carta = new Carta(i, Naipe.Clubs);
            cartas.add(carta);

            carta = new Carta(i, Naipe.Diamonds);
            cartas.add(carta);

            carta = new Carta(i, Naipe.Hearts);
            cartas.add(carta);

            carta = new Carta(i, Naipe.Spades);
            cartas.add(carta);
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        return cartas.remove(0);
    }
}
