package ifpr.pgua.eic.exemplo.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ifpr.pgua.eic.exemplo.models.Veiculo;

public class Leitor 
{
    public ArrayList<Veiculo> carregar(String nomeArquivo)
    {
        ArrayList<Veiculo> lista= new ArrayList<>();

        try
        {
            FileReader fr=new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();
            while(linha !=null)
            {
                String[] tokens = linha.split(";");
                String placa = tokens[0];
                String modelo = tokens[1];
                String fabricante = tokens[2];
                int anoFabricacao = Integer.valueOf(tokens[3]);
                String cor= tokens[4];
                linha = br.readLine();

                Veiculo v= new Veiculo(placa, modelo, fabricante, anoFabricacao, cor);

                lista.add(v);

                linha=br.readLine();
            }
            br.close();
            fr.close();    
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
