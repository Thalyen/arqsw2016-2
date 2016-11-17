package sisnp.ifrn.br.negocio;

import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAProjeto;

public class BLProjeto {
    private DAProjeto dataAccess = null;
    
    public BLProjeto() {
        super();
        dataAccess = new DAProjeto();
    }
    
    public Projeto getProjeto(int idProjeto) {
        return dataAccess.getProjeto(idProjeto);
    }
}
