package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Atividade;
import sisnp.ifrn.br.dominio.Meta;

/**
 *
 * @author Tat
 */
public class DAMeta {
     private Connection conn;

    public DAMeta() {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public ArrayList<Meta> getMeta(int idProjeto) {
       
        ArrayList<Meta> lista = new ArrayList<>();
       
       if (conn != null) {
            try {
                PreparedStatement psGetMeta = conn.prepareStatement
                ("SELECT * FROM meta WHERE projeto_id = ? order by data_fim desc limit 3");
                psGetMeta.setInt(1, idProjeto);
                ResultSet rsGetMeta = psGetMeta.executeQuery();

                while (rsGetMeta.next()) {
                    Meta meta = new Meta();
                    meta.setId(rsGetMeta.getInt("id"));
                    meta.setTitulo(rsGetMeta.getString("titulo"));
                    meta.setDataInicio(rsGetMeta.getDate("data_inicio").toString());
                    meta.setDataFim(rsGetMeta.getDate("data_fim").toString());
                    meta.setAtividades(getAtividades(rsGetMeta.getInt("id")));

                    lista.add(meta);
                }

                psGetMeta.close();
                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList<Atividade> getAtividades(int idMeta) {
       
      ArrayList<Atividade> listaAtividade = new ArrayList<>();
       
       if (conn != null) {
            try {
                PreparedStatement psGetAtividade = conn.prepareStatement("SELECT * FROM atividade WHERE meta_id = ?");
                psGetAtividade.setInt(1, idMeta);
                ResultSet rsGetAtiviade = psGetAtividade.executeQuery();

                while (rsGetAtiviade.next()) {
                    Atividade atividade = new Atividade();
                    atividade.setId(rsGetAtiviade.getInt("atividade.id"));
                    atividade.setTitulo(rsGetAtiviade.getString("atividade.titulo"));
                    atividade.setDescricao(rsGetAtiviade.getString("atividade.descricao"));
                    atividade.setDataInicio(rsGetAtiviade.getString("atividade.data_inicio"));
                    atividade.setDataFim(rsGetAtiviade.getString("atividade.data_fim"));
                    atividade.setIdMEta(rsGetAtiviade.getInt("atividade.meta_id"));
                    
                    listaAtividade.add(atividade);
                }

                psGetAtividade.close();
                return listaAtividade;
                
                

            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
