/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Atividade;

/**
 *
 * @author Tat
 */
public class DAAtividade {

    private Connection conn;

    public DAAtividade() {
        super();
        conn = FabricaConexao.getInstancia().getConexao();
    }

    public ArrayList<Atividade> getAtividades(int idMeta) {
        ArrayList<Atividade> lista = new ArrayList<>();
        if (conn != null) {
            try {
                PreparedStatement psGetAtividade = conn.prepareStatement("SELECT * FROM atividade WHERE meta_id = ?");
                psGetAtividade.setInt(1, idMeta);
                ResultSet rsGetAtividade = psGetAtividade.executeQuery();

                while (rsGetAtividade.next()) {
                    Atividade atividade = new Atividade();
                    atividade.setId(rsGetAtividade.getInt("id"));
                    atividade.setTitulo(rsGetAtividade.getString("titulo"));
                    atividade.setDescricao(rsGetAtividade.getString("descricao"));
                    atividade.setDataInicio(rsGetAtividade.getDate("data").toString());
                    atividade.setDataFim(rsGetAtividade.getDate("data").toString());

                    lista.add(atividade);
                }

                psGetAtividade.close();
                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
