package com.company.Test;

import java.io.*;

public class WriteNotNullRoot {
//    public static void WriteNotNullRoot(Ditopn root){
//        FileOutputStream file = null;
//        try {
//            file = new FileOutputStream("C:\\Brilliance\\WorkSpace\\gjjs-common\\src\\main\\resources\\template\\a.json");
//            new ObjectMapper().writeValue(file, root);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        BufferedReader reader = null;
//        StringBuilder sb = new StringBuilder();
//        try {
//            File fileIn = new File("C:\\Brilliance\\WorkSpace\\gjjs-common\\src\\main\\resources\\template\\a.json");
//            reader = new BufferedReader(new FileReader(fileIn));
//            String tempString = null;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                if (!(tempString.length() > 4 && ((tempString.charAt(tempString.length() - 5) == ':') || tempString.indexOf("null") > -1 || tempString.indexOf(": 0.00,") > -1 ||  tempString.indexOf(": 0,") > -1 ))) {
//                    sb.append(tempString);
//                }
//            }
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//        FileOutputStream file2 = null;
//        try {
//            file2 = new FileOutputStream("C:\\Brilliance\\WorkSpace\\gjjs-common\\src\\main\\resources\\template\\a.json");
//            new ObjectMapper().writeValue(file2, sb.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
