package com.company.All;

//306. 累加数

public class isAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        boolean flag = false;
        for(int i = 1; i < num.length(); i++){
            String temp_num = num.substring(0, i);
            if(temp_num.charAt(0) == '0' && temp_num.length() > 1){
                continue;
            }
            flag |= check(num.substring(i), Double.parseDouble(temp_num));
        }
        return flag;
    }

    public boolean check(String num, double m){
        if(num.length() == 0){
            return true;
        }
        for(int i = 0; i < num.length(); i++){
            double temp_left = Double.parseDouble(num.substring(0, i + 1));
            if(num.charAt(0) == '0' && temp_left > 0){
                break;
            }else{
                for(int j = i + 1; j < num.length(); j++){
                    double temp_right = Double.parseDouble(num.substring(i + 1, j + 1));
                    if(num.charAt(i + 1) == '0' && j - i > 1){
                        break;
                    }else{
                        if(m + temp_left == temp_right){
                            if(j == num.length() - 1){
                                return true;
                            }else{
                                if(check(num.substring(i + 1), temp_left)){
                                    return true;
                                }
                            }
                        }
                        if(m + temp_left < temp_right){
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isAdditiveNumber isAdditiveNumber = new isAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("111122335588143"));
    }
}
