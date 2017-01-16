package sisnp.ifrn.br.dominio;

import java.util.List;

public class Projeto {

    private int id;
    private String titulo;
    private String descricao;
    private List<Noticia> noticias;
    private List<Meta> metas;
    private List<Usuario> equipe;

    public List<Usuario> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Usuario> equipe) {
        this.equipe = equipe;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public Projeto() {
        super();
    }

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

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticias = noticia;
    }
}
