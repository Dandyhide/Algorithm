package com.company.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TxtIO {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        FileWriter file = null;
        try {
            file = new FileWriter("D:\\rootPath\\POSTLOG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(file);
        try {
            write(map, bw);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Map<String, String> map, BufferedWriter bw){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                bw.write(entry.getValue() + "          " + entry.getKey());
                bw.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
