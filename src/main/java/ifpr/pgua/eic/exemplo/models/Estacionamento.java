package ifpr.pgua.eic.exemplo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Estacionamento {
    private String nome;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    
    public Estacionamento(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        veiculos = new ArrayList<>();
    }

    public void geraFakes(){
        veiculos.add(new Veiculo("aaa-1121", "Modelo 1", "Fabricante 1", 2001, "Cor1"));
        veiculos.add(new Veiculo("aab-1122", "Modelo 2", "Fabricante 2", 2002, "Cor2"));
        veiculos.add(new Veiculo("aba-1123", "Modelo 3", "Fabricante 3", 2003, "Cor3"));
        veiculos.add(new Veiculo("bbc-1124", "Modelo 4", "Fabricante 4", 2004, "Cor4"));
        
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Veiculo> listaTodosVeiculos(){
        return veiculos;
    }

    public ArrayList<Veiculo> listaVeiculosEstacionados(){
        return new ArrayList<>(veiculos.stream().filter(veiculo -> veiculo.isEstaEstacionado()).collect(Collectors.toList()));
    }

    public Veiculo buscarVeiculo(String placa){
        for(Veiculo veiculo:veiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    /*Recebe o inicio de uma placa e retorna todos os veículos com aquele início de placa */
    public List<Veiculo> filtrarVeiculosPlaca(String inicioPlaca){
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().startsWith(inicioPlaca)).collect(Collectors.toList());
    }

    public boolean cadastraVeiculo(String placa, String modelo, String fabricante, int anoFabricacao, String cor){
        if(buscarVeiculo(placa)==null){
            Veiculo veiculo = new Veiculo(placa, modelo, fabricante, anoFabricacao, cor);

            veiculos.add(veiculo);

            return true;

        }

        return false;
    }


    public boolean registraEntrada(String placa){
        Veiculo veiculo = buscarVeiculo(placa);
        if(veiculo != null && !veiculo.isEstaEstacionado()){
            veiculo.registraEntrada();
            return true;
        }
        return false;
    }

    public boolean registraSaida(String placa){
        Veiculo veiculo = buscarVeiculo(placa);
        if(veiculo != null && veiculo.isEstaEstacionado()){
            
            veiculo.registraSaida();

            return true;
        }
        return false;
    }




}
