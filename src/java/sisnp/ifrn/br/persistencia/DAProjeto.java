package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Projeto;

public class DAProjeto {
    
    private Connection conn;
    private final String DRIVER =  "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "adminadmin";
    
    public DAProjeto() {
        super();
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Projeto getProjeto(int idProjeto) {
        if (conn != null) {
            try {
                PreparedStatement psGetProjeto = conn.prepareStatement
                                  ("SELECT * FROM projeto WHERE id = ?");
                psGetProjeto.setInt(1, idProjeto);
                ResultSet rsGetProjeto = psGetProjeto.executeQuery();
                Projeto projeto = new Projeto();
                if (rsGetProjeto.next()) {
                    projeto.setId(rsGetProjeto.getInt("id"));
                    projeto.setTitulo(rsGetProjeto.getString("titulo"));
                    projeto.setDescricao(rsGetProjeto.getString("descricao"));
                    psGetProjeto.close();
                    return projeto;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
