package sisnp.ifrn.br.dominio;

/**
 *
 * @author Tat
 */
public class Noticia {
    
    private int id;
    private String titulo;
    private String descricao;
    private String data;
    private int projetos_id;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getProjetos_id() {
        return projetos_id;
    }

    public void setProjetos_id(int projetos_id) {
        this.projetos_id = projetos_id;
    }
    
}
