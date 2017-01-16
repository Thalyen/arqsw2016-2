
package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Usuario;

/**
 *
 * @author Tat
 */
public class DAEquipe {

    private Connection conn;

    public DAEquipe() {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public ArrayList<Usuario> getEquipe(int idProjeto) {

        ArrayList<Usuario> lista = new ArrayList<>();

        if (conn != null) {
            try {
                PreparedStatement psGetEquipe = conn.prepareStatement("SELECT usuario.id,\n"
                        + "    usuario.nome,\n"
                        + "    usuario.login,\n"
                        + "    usuario.senha,\n"
                        + "    usuario.ativo\n"
                        + "FROM usuario, projeto, discente_projeto, docente_projeto\n"
                        + "where  \n"
                        + "usuario.id = discente_projeto.id_discente and\n"
                        + "projeto.id = discente_projeto.id_projeto and\n"
                        + "usuario.ativo = true or\n"
                        + "usuario.id = docente_projeto.id_docente and\n"
                        + "projeto.id = docente_projeto.id_projeto  and\n"
                        + "usuario.ativo = true and\n"
                        + "projeto.id = ?");
                psGetEquipe.setInt(1, idProjeto);
                ResultSet rsGetEquipe = psGetEquipe.executeQuery();

                while (rsGetEquipe.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rsGetEquipe.getInt("id"));
                    usuario.setNome(rsGetEquipe.getString("nome"));

                    lista.add(usuario);
                }

                psGetEquipe.close();
                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
