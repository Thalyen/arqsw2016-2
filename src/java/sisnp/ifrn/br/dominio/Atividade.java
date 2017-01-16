package sisnp.ifrn.br.dominio;

/**
 *
 * @author Tat
 */
import java.sql.Date;

public class Atividade {

    private int id;
    private String titulo;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private int idMeta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMEta(int idm) {
        this.idMeta = idm;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
