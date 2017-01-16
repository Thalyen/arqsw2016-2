package sisnp.ifrn.br.negocio;

import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DANoticia;
import sisnp.ifrn.br.persistencia.DAProjeto;
import sisnp.ifrn.br.persistencia.DAMeta;
import sisnp.ifrn.br.persistencia.DAEquipe;

public class ModuloProjeto implements MProjetoDocente {
    
    private DAProjeto dAProjeto = null;
    private DANoticia dANoticia = null;
    private DAMeta dAMeta = null;
    private DAEquipe dAEquipe = null;
    
    public ModuloProjeto() {
        super();
        dAProjeto = new DAProjeto();
        dANoticia = new DANoticia();
        dAMeta = new DAMeta();
        dAEquipe = new DAEquipe();
    }
    
    @Override
    public Projeto visaoGeralProjeto(int idProjeto) {
        Projeto projeto = dAProjeto.getProjeto(idProjeto);
        projeto.setNoticia(dANoticia.getNoticia(idProjeto));
        projeto.setMetas(dAMeta.getMeta(idProjeto));
        projeto.setEquipe(dAEquipe.getEquipe(idProjeto));
        return projeto;
    }
}
