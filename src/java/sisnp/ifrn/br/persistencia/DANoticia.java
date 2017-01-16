package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Noticia;

/**
 *
 * @author Tat
 */

public class DANoticia {

    private Connection conn;

    public DANoticia() {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public ArrayList<Noticia> getNoticia(int idProjeto) {
        
        ArrayList<Noticia> lista = new ArrayList<>();
        
        if (conn != null) {
            try {
                PreparedStatement psGetNoticia = conn.prepareStatement
                ("SELECT * FROM noticias WHERE projetos_id = ? order by data desc limit 3");
                psGetNoticia.setInt(1, idProjeto);
                ResultSet rsGetNoticia = psGetNoticia.executeQuery();

                while (rsGetNoticia.next()) {
                    Noticia noticia = new Noticia();
                    noticia.setId(rsGetNoticia.getInt("id"));
                    noticia.setTitulo(rsGetNoticia.getString("titulo"));
                    noticia.setDescricao(rsGetNoticia.getString("descricao"));
                    noticia.setData(rsGetNoticia.getDate("data").toString());

                    lista.add(noticia);
                }

                psGetNoticia.close();
                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
