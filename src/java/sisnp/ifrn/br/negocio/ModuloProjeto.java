package sisnp.ifrn.br.negocio;

import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAProjeto;

public class ModuloProjeto implements MProjetoDocente {
    private DAProjeto dAProjeto = null;
    
    public ModuloProjeto() {
        super();
        dAProjeto = new DAProjeto();
    }
    
    public Projeto visaoGeralProjeto(int idProjeto) {
        Projeto projeto = dAProjeto.getProjeto(idProjeto);
        // ...
        return projeto; 
    }
}
