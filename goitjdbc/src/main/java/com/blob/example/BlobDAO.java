package com.blob.example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * Created by denys on 6/8/2017.
 */
public class BlobDAO {

    public void saveBlob(Record record) throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO Hello.videos(name, data) VALUES(?,?)");
            ps.setString(1, record.getName());
            byte[] content = record.getDataContent();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
            ps.setBlob(2, inputStream);
            ps.execute();
        }
    }

    public Record readRecord(String name) throws Exception {
        Record record = new Record();
        try(Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Hello.videos WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("------Before Meta Data----------");
            for(int i=0;i<meta.getColumnCount();i++){
                String columnMeta=meta.getColumnClassName(i+1);
                String columnTypeMeta=meta.getColumnTypeName(i+1);
                System.out.println(columnMeta);
                System.out.println(columnTypeMeta);
                System.out.println();
            }
            System.out.println("------After Meta Data----------");

            while(rs.next()){
                try(InputStream in = rs.getBinaryStream("data")){
                    byte[] data=RecordUtils.getInstance().readFromInputStream(in);
                    record.setDataContent(data);
                }
            }
        }
        record.setName(name);
        return record;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hello","root","111111");
    }
}
