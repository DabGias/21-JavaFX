package com.example.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas = new ArrayList<Carta>();

    public Monte() {
        
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta virar() {
        Carta carta = cartas.get(0);
        cartas.remove(0);

        return carta;
    }
}
