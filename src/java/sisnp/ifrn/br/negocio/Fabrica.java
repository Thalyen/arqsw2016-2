package sisnp.ifrn.br.negocio;

public class Fabrica {
    public static MProjetoDocente getMProjetoDocente() {
        return new ModuloProjeto();
    }
}
