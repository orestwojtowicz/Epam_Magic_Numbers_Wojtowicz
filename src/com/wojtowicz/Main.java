package com.wojtowicz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(readHexValues(new File("resources/angular.png")));


    }
    public static List<String> readHexValues(File file) {

        List<String> dataList = null;

        try (InputStream inputstream = new FileInputStream(file.getPath())) {
            dataList = new ArrayList<>();
            int data = inputstream.read();

            while (dataList.size() <= 3) {
                dataList.add(Integer.toHexString(data));
                data = inputstream.read();
            }
        } catch (IOException e) {
            System.out.println("Error while reading byte values from file " +
                    file.getName() + "\n" + e.getMessage());
            e.printStackTrace();
        }
        return dataList;
    }
}
