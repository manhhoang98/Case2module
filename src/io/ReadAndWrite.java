package io;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite<E> {
    public void write(File file, ArrayList<E> list) {
        try {
            //kết nối
            FileOutputStream ketnoi = new FileOutputStream(file);
            //tạo bút
            ObjectOutputStream but = new ObjectOutputStream(ketnoi);
            but.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ArrayList<E> read(File file) {
        try {
            //Kết nối
            FileInputStream ketnoi = new FileInputStream(file);
            // tạo but
            ObjectInputStream but = new ObjectInputStream(ketnoi);
            return (ArrayList<E>) but.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
