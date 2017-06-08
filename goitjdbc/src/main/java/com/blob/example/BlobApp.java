package com.blob.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by denys on 6/8/2017.
 */
public class BlobApp {




    public static void main(String[] args) throws Exception {
        initLogger();
        String name = "Artist1";
        File video = new File("C:\\Users\\denys\\q\\New folder\\middle\\goitjdbc\\src\\main\\resources\\videos\\json-20080701.jar");
        Record record = RecordUtils.getInstance().initRecord(name, video);
        BlobDAO blobDAO = new BlobDAO();
       // blobDAO.saveBlob(record);
        Record result = blobDAO.readRecord(name);
        RecordUtils.getInstance().saveRecordToFileSystem(record, "res.jar");

    }

    private static void initLogger() throws FileNotFoundException {
        String tmpPath = System.getenv("TEMP");
        PrintStream ps = new PrintStream(new File(tmpPath, "Java-app.log"));
        System.setOut(ps);
    }

}
