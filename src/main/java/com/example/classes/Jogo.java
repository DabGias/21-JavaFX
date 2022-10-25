package com.example.classes;

public class Jogo {
    Monte monte = new Monte();
    Jogador jogador = new Jogador();
    Computador comp = new Computador();

    public Jogo() {
        Monte monte = new Monte();
        monte.embaralhar();
    }

    public Carta distribuiCartaParaJogador(Jogador jog) {
        if (jog.isParou() == false) {
            return monte.virar();
        }

        return null;
    }

    public boolean acabou() {
        if (jogador.isParou() && comp.isParou() || jogador.getPontos() > 21 || comp.getPontos() > 21) {
            return true;
        }

        return false;
    }

    public String resultado() {
        if (jogador.getPontos() == 21 || comp.getPontos() > 21) {
            return "Você ganhou!";
        } else if (comp.getPontos() == 21 || jogador.getPontos() > 21) {
            return "Você perdeu!";
        } else if (jogador.getPontos() == comp.getPontos() && jogador.isParou() && comp.isParou()) {
            return "Empate";
        }

        return null;
    }
}
