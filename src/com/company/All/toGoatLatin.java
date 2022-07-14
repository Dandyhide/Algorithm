package com.company.All;

public class toGoatLatin {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        char[] coordinate = new char[]{'a','e','i','o','u'};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            StringBuilder sb_1 = new StringBuilder();
            String temp = s[i];
            boolean flag = true;
            for(int j = 0; j < coordinate.length; j++){
                if(coordinate[i] == temp.indexOf(0)){
                    sb_1.append(temp);
                    flag = false;
                }
            }
            if(flag){
                sb_1.append(temp.substring(1));
                sb_1.append(temp.substring(0,1));
            }
            sb_1.append("ma");
            for(int k = 0; k <= i; k++){
                sb_1.append("a");
            }
            sb.append(sb_1.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
