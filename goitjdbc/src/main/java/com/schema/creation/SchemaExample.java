package com.schema.creation;

import java.sql.SQLException;

/**
 * Created by denys on 6/8/2017.
 */
public class SchemaExample {

    public static void main(String[] args) throws SQLException {
        SchemaCreator schemaCreator = new SchemaCreator();
        schemaCreator.createSchema("Hello");
    }

}
