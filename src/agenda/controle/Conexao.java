package agenda.controle;

import agenda.exception.AgendaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() throws AgendaException{
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/agendadb", "sa", "");
        } catch (SQLException e) {
            throw  new AgendaException("Problemas ao conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            throw  new AgendaException("Problemas ao conectar no banco de dados");
        }

        return conn;
    }
}
