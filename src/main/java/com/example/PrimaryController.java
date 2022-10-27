package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.classes.Carta;
import com.example.classes.Jogo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {
    @FXML private HBox hBoxMesaDoJogador;
    @FXML private HBox hBoxMesaDoComputador;
    @FXML private ImageView imgViewMonte;

    @FXML private Label labelPontosMesa;
    @FXML private Label labelPontosJogador;
    @FXML private Label labelResultado;

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String user = "";
    private String password = "";

    private Jogo jogo = new Jogo();
    
    public void novoJogo() {
        jogo = new Jogo();

        hBoxMesaDoComputador.getChildren().clear();
        hBoxMesaDoJogador.getChildren().clear();
        atualizar();
    }
    
    public void pedirCarta() {
        turno();
    }

    public void parar() {
        jogo.getJogador().setParou(true);

        turno();
    }

    private void turno() {
        Carta cartaJogador = jogo.distribuiCartaParaJogador(jogo.getJogador());
        Carta cartaComp = jogo.distribuiCartaParaJogador(jogo.getComputador());

        if (cartaJogador != null) {
            jogo.getJogador().receberCarta(cartaJogador);
            hBoxMesaDoJogador.getChildren().add(imagemCarta(cartaJogador));
        }

        if (cartaComp != null) {
            jogo.getComputador().receberCarta(cartaComp);
            hBoxMesaDoComputador.getChildren().add(imagemCarta(cartaComp));
        }

        atualizar();
        if (jogo.acabou()) {
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stm = con.prepareStatement("insert into vinte_um_ddd values (?, ?, ?)");
    
                stm.setInt(1, jogo.getJogador().getPontos());
                stm.setInt(2, jogo.getComputador().getPontos());
                stm.setString(3, jogo.resultado());

                stm.execute();
                con.close();
    
                labelResultado.setText(jogo.resultado());
            } catch(SQLException e) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setContentText("Erro: " + e.getMessage());
                alerta.show();
            }
        } else if (jogo.getJogador().isParou()) {
            turno();
        }
    }

    private void atualizar() {
        labelPontosJogador.setText("Você: " + jogo.getJogador().getPontos());
        labelPontosMesa.setText("Mesa: " + jogo.getComputador().getPontos());
        labelResultado.setText("");
    }

    private ImageView imagemCarta(Carta carta) {
       return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }
}
