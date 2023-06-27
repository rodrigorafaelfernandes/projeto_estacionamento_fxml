package ifpr.pgua.eic.exemplo;

import java.util.ArrayList;

import ifpr.pgua.eic.exemplo.controllers.TelaCadastro;
import ifpr.pgua.eic.exemplo.controllers.TelaPrincipal;
import ifpr.pgua.eic.exemplo.controllers.TelaVisualizar;
import ifpr.pgua.eic.exemplo.infra.Escritor;
import ifpr.pgua.eic.exemplo.infra.Leitor;
import ifpr.pgua.eic.exemplo.models.Estacionamento;
import ifpr.pgua.eic.exemplo.models.Veiculo;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;
import io.github.hugoperlin.navigatorfx.ScreenRegistryNoFXML;


/*A classe App extende a classe BaseAppNavigator, o que
 * permite fazer a navegação entre telas.
 */
public class App extends BaseAppNavigator{


    /*gerenciador do estacionamento que será compartilhado com as diferentes telas
     * da aplicação.
     */
    private Estacionamento gerenciador;


    /*método utilizado para inicializar dependências da aplicação. Este
     * método é executado sempre uma vez no início da aplicação.
     */
    @Override
    public void init() throws Exception {
        super.init();

        gerenciador = new Estacionamento("SuperEstac", "1234-1234");

        Leitor leitor = new Leitor();
        ArrayList<Veiculo> lista = leitor.carregar("veiculos.txt");
        gerenciador.setVeiculos(lista);
    }

    @Override
    public void stop() throws Exception {
        // TODO Auto-generated method stub
        super.stop();

        Escritor escritor=new Escritor();
        escritor.salvar("veiculos.txt",gerenciador.listaTodosVeiculos());
    }

    /*método para indicar qual é a tela inicial da aplicação */
    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    /*método para indicar o nome da aplicação */
    @Override
    public String getAppTitle() {
        return "Quiz App";
    }

    /*método para registrar as telas da aplicação*/
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL",
                      new ScreenRegistryFXML(App.class, 
                                         "principal.fxml", 
                                          o->new TelaPrincipal()));
        registraTela("CADASTRO", 
                      new ScreenRegistryFXML(App.class, 
                                             "cadastro.fxml",
                                            o->new TelaCadastro(gerenciador)));
        registraTela("VISUALIZAR",
                     new ScreenRegistryFXML(App.class, 
                                           "visualizar.fxml", o->new TelaVisualizar(gerenciador)));                                
    
        }
    
}
