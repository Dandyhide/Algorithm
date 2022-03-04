package com.company.Everyday;

public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        int[] temp = new int[]{26, 26*26, 26*26*26, 26*26*26*26, 26*26*26*26*26, 26*26*26*26*26};
        int len = 0;
        while (columnNumber - temp[len] > temp[len + 1]){
            columnNumber -= temp[len++];
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 1){
            sb.append((char)((columnNumber % 26)+'0'+'0'-32));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
