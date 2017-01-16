package sisnp.ifrn.br.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
    private static FabricaConexao instancia1; 
    private static FabricaConexao instancia2;
    private static int ultimaUsada = 2;
    
    private Connection conn;
    private final String DRIVER =  "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnpBD2";
    private final String USER = "root";
    private final String PASS = "root";
    
    private FabricaConexao() {
        super();
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(BANCO, USER, PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public static FabricaConexao getInstancia() {
        if (ultimaUsada == 2) {
            if (instancia1 == null) {
                instancia1 = new FabricaConexao();
            }
            ultimaUsada = 1;
            return instancia1;
        } else {
            if (instancia2 == null) {
                instancia2 = new FabricaConexao();
            }
            ultimaUsada = 2;
            return instancia2;
        }
    }
    
    public Connection getConexao() {
        return conn;
    }
}
