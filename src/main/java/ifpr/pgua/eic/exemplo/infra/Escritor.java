package ifpr.pgua.eic.exemplo.infra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ifpr.pgua.eic.exemplo.models.Veiculo;

public class Escritor 
{
    public boolean salvar(String nomeArquivo,ArrayList<Veiculo>lista)
    {
        try{
            FileWriter fw = new FileWriter(nomeArquivo);   
            BufferedWriter bw= new BufferedWriter(fw);
            
            for(Veiculo v:lista)
            {
                String linha = String.join(";", v.getPlaca(), v.getModelo(), v.getFabricante(), v.getAnoFabricacao()+"", v.getCor());
                bw.write(linha);
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }






}
