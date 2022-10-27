package com.example.classes;

public class Jogo {
    Monte monte;
    Jogador jogador = new Jogador();
    Computador comp = new Computador();

    public Jogo() {
        monte = new Monte();
        monte.embaralhar();
    }

    public Carta distribuiCartaParaJogador(Jogador jog) {
        if (jog.isParou() == false) {
            return monte.virar();
        }

        return null;
    }

    public boolean acabou() {
        return jogador.isParou() && comp.isParou() || jogador.getPontos() >= 21 || comp.getPontos() >= 21;
    }

    public String resultado() {
        if ((jogador.getPontos() > 21 && comp.getPontos() <= 21) || (jogador.getPontos() < comp.getPontos())) {
            return "Você perdeu!";
        } else if (jogador.getPontos() == comp.getPontos() || jogador.getPontos() > 21 && comp.getPontos() > 21) {
            return "Empate!";
        } else {
            return "Você ganhou!";
        }

        // if (jogador.getPontos() == 21 || 21 > jogador.getPontos() && 21 > comp.getPontos() && jogador.getPontos() > comp.getPontos()) {
        //     return "Você ganhou!";
        // } else if (comp.getPontos() == 21 || 21 > comp.getPontos() && 21 > jogador.getPontos() && comp.getPontos() > jogador.getPontos()) {
        //     return "Você perdeu!";
        // } else if (jogador.getPontos() == comp.getPontos() || jogador.getPontos() > 21 && comp.getPontos() > 21) {
        //     return "Empate";
        // }
    }

    public Jogador getJogador() {
        return this.jogador;
    } 

    public Computador getComputador() {
        return this.comp;
    }
}
