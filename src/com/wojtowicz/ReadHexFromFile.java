package com.wojtowicz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public abstract class ReadHexFromFile {

    public List<String> readHexValues(File file) {

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
