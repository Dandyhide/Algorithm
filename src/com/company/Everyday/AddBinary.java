package com.company.Everyday;

//TODO

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = charA.length, j = charB.length;
        for (; i >= 0 && j >= 0; i--, j--){
            int temp = (charA[i] - '0') + (charB[j] - '0') + carry;
            if (temp == 2){
                sb.append(0);
                carry = 1;
            }else{
                sb.append(temp);
            }
        }
        if (carry == 1){
            if (i > 0){
                for (;i >= 0; i--){
                    int temp = (charA[i] - '0') + carry;
                    if (temp == 2){
                        sb.append(0);
                        carry = 1;
                    }else{
                        sb.append(temp);
                    }
                }
            }else{
                for (;j >= 0; j--){
                    int temp = (charB[j] - '0') + carry;
                    if (temp == 2){
                        sb.append(0);
                        carry = 1;
                    }else{
                        sb.append(temp);
                    }
                }
            }
        }else{
            if (i > 0){
                sb.append(a.substring(0, i));
            }else{
                sb.append(b.substring(0, j));
            }
        }
        return sb.reverse().toString();
    }
}
