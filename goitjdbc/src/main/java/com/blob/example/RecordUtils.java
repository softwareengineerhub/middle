package com.blob.example;

import java.io.*;

/**
 * Created by denys on 6/8/2017.
 */
public class RecordUtils {

    private static RecordUtils instance;

    private RecordUtils() {
    }

    public Record initRecord(String name, File videoFile) throws Exception {
        Record record = new Record();
        record.setName(name);
        byte[] data = transformFileToBytes(videoFile);
        record.setDataContent(data);
        return record;
    }

    private byte[] transformFileToBytes(File file) throws Exception {
        byte[] data = null;
        try(InputStream in = new FileInputStream(file);){
            return  readFromInputStream(in);
        }
    }

    public byte[] readFromInputStream(InputStream in) throws Exception {
        byte[] data = new byte[in.available()];
        in.read(data);
        return data;
    }

    public static synchronized RecordUtils getInstance(){
        if(instance==null){
            instance = new RecordUtils();
        }
        return instance;
    }

    public void saveRecordToFileSystem(Record record, String fileName) throws Exception {
        //String tmpPath = "C:\\Users\\denys\\q\\New folder\\middle\\goitjdbc\\src\\main\\resources\\videos\\";
        //java.io.tmpdir
        String tmpPath = System.getenv("TEMP");
        File tmp = new File(tmpPath, fileName);
        try(OutputStream out = new FileOutputStream(tmp);){
            out.write(record.getDataContent());
        }
    }
}
