package ifpr.pgua.eic.exemplo.controllers;

import ifpr.pgua.eic.exemplo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal {

    @FXML
    public void abrirTelaCadastro(ActionEvent event) {
        App.pushScreen("CADASTRO");
    }

    @FXML
    public void abrirTelaVisualizar(ActionEvent event) {
        App.pushScreen("VISUALIZAR");
    }

}
