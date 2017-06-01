package transaction.app;

import java.sql.SQLException;

/**
 * Created by denys on 6/1/2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        /*
        Transaction - a set of operations or commands
        ACID rules
        1. Atomicity - all or no one
            1.1. update
            1.2. insert
            1.3. delete  - error (incorrect SQL)

        2. Consistency
            Transaction must be committed(+) or rolled back(-)

        3. Isolation

        4. Durability
         */

        User user = new User("Name6","Role6","Email6");
        User user1 = new User("Name7","Role7","Email7");
        TransactionsDAO dao = new TransactionsDAO();
        dao.makeTransaction(user);
        dao.makeTransaction(user1);
    }

}
