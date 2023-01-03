import java.sql.*;

public class Koneksi {

    private static Connection cn;

    public static Connection getConnection() throws SQLException{
        String db = "jdbc:mysql://localhost/game leaderboard";
        String user = "root";
        String password = "";

        if(cn == null){
            cn = DriverManager.getConnection(db, user, password);
        }

        return cn;
    }
    
}
