package acesso_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoUtil {

    private Connection con = null;

    public Connection startConnection() {
        String user = "root";
        String pws = "";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=convertToNull";

        try {
            if (this.con == null) {
                //Carregar e registrar a classe de driver do JDBC
                Class.forName(driver);
                //Obter uma conexão com o banco passando
                // os parâmetros necessários
                con = DriverManager.getConnection(url, user, pws);
            }
        } catch (ClassNotFoundException cnf) {
            System.out.println("Erro de DRIVER");
            System.out.println("Error :" + cnf);

        } catch (SQLException se) {
            System.out.println("Erro de SQL");
            System.out.println("Mensagem :" + se.getMessage());
            System.out.println("Cód.     :" + se.getErrorCode());
            System.out.println("SQL State:" + se.getSQLState());
        } catch (Exception e) {
            System.out.println("Erro geral :" + e);

        }
        return con;
    }

    public Object getStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
