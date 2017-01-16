package sisnp.ifrn.br.dominio;

import java.util.List;

/**
 *
 * @author Tat
 */
public class Meta {

    private int id;
    private String titulo;
    private String dataInicio;
    private String dataFim;
    private List<Atividade> atividades;
    private int projeto_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public int getProjeto_id() {
        return projeto_id;
    }

    public void setProjeto_id(int projeto_id) {
        this.projeto_id = projeto_id;
    }


}
