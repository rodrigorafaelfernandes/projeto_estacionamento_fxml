package ifpr.pgua.eic.exemplo.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.exemplo.App;
import ifpr.pgua.eic.exemplo.models.Estacionamento;
import ifpr.pgua.eic.exemplo.models.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class TelaVisualizar implements Initializable{

    @FXML
    private ListView<Veiculo> lstVeiculos;

    @FXML
    private TextArea taDetalhes;

    @FXML
    private TextField tfPlaca;

    private Estacionamento estacionamento;

    public TelaVisualizar(Estacionamento estacionamento){
        this.estacionamento = estacionamento;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        atualizarLista();
    }

    private void atualizarLista(){
        lstVeiculos.getItems().clear();
        lstVeiculos.getItems().addAll(estacionamento.listaTodosVeiculos());
    }

    @FXML
    void exibirDetalhes(MouseEvent event) {
        Veiculo veiculo = lstVeiculos.getSelectionModel().getSelectedItem();
        if(veiculo != null){
            taDetalhes.clear();
            taDetalhes.appendText("Placa:"+veiculo.getPlaca());
            taDetalhes.appendText("\nModelo:"+veiculo.getModelo());
            taDetalhes.appendText("\nAno:"+veiculo.getAnoFabricacao());
            taDetalhes.appendText("\nCor:"+veiculo.getCor());
            taDetalhes.appendText("\nFabricante:"+veiculo.getFabricante());
            
            
            
        }
    }

    @FXML
    void buscar(ActionEvent event) {
        filtrarVeiculos();
    }

    @FXML
    void teclar(KeyEvent event) {
        filtrarVeiculos();
    }

    private void filtrarVeiculos(){
        lstVeiculos.getItems().clear();
        if(tfPlaca.getText().isEmpty()){
            lstVeiculos.getItems().addAll(estacionamento.listaTodosVeiculos());
        }else{
            lstVeiculos.getItems().addAll(estacionamento.filtrarVeiculosPlaca(tfPlaca.getText()));
        }
    }


    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}

