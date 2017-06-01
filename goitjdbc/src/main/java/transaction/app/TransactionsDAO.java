package transaction.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by denys on 6/1/2017.
 */
public class TransactionsDAO {

    public void makeTransaction(User user) throws SQLException {
        try(Connection c = getConnection()){
            System.out.println("Connection.hashCode="+c.hashCode());
            //c.setAutoCommit(); default == true
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("INSERT INTO users(name, user_role, email) VALUES(?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getRole());
            ps.setString(3, user.getEmail());
            ps.execute();

            ps=c.prepareStatement("UPDATE mydb.users SET user_role=? WHERE name=?");
            ps.setString(1, "TransactionRole"+System.currentTimeMillis());
            //user = null;
            ps.setString(2, user.getName());
            ps.execute();
            c.commit();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false","root","111111");
    }


}
