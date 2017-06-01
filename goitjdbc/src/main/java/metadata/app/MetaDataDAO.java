package metadata.app;

import java.sql.*;

/**
 * Created by denys on 6/1/2017.
 */
public class MetaDataDAO {

    public void printMeta(String tableName) throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps=c.prepareStatement("SELECT * FROM "+tableName);
            //ps.setString(1, tableName);
            ResultSet rs=ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int n=metaData.getColumnCount();
            for(int i=0;i<n;i++){
                String columnName=metaData.getColumnName(i+1);
                String className=metaData.getColumnClassName(i+1);
                System.out.println(columnName+"; "+className);
            }

            System.out.println("---------------------------------");

           while(rs.next()){
               for(int i=0;i<n;i++){
                   String columnName=metaData.getColumnName(i+1);
                   //String className=metaData.getColumnClassName(i+1);
                   Object obj=rs.getObject(columnName);
                   System.out.print(obj+" ");
               }
               System.out.println();
           }
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false","root","111111");
    }

}
