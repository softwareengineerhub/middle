package metadata.app;

import java.sql.SQLException;

/**
 * Created by denys on 6/1/2017.
 */
public class MetaApp {

    public static void main(String[] args) throws SQLException {
        MetaDataDAO dao = new MetaDataDAO();
        //dao.printMeta("mydb.users");
        dao.printMeta("mydb.address");

    }

}
