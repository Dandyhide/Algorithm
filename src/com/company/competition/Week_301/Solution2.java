package com.company.competition.Week_301;

public class Solution2 {
    public boolean canChange(String start, String target) {
        int count_L = 0, count_R = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) == 'L'){
                count_L++;
            }else if(start.charAt(i) == 'R'){
                count_R++;
            }
            if(target.charAt(i) == 'L'){
                count_L--;
            }else if(target.charAt(i) == 'R'){
                count_R--;
            }
        }
        if(count_L != 0 || count_R != 0){
            return false;
        }
        int left = 0, right = 0;
        char[] chars_start = start.toCharArray();
        char[] chars_target = target.toCharArray();
        while (right < chars_target.length){
            if (chars_target[right] == '_'){
                if(chars_start[left] == 'R'){
                    remove(chars_start, left);
                }
                if(chars_start[left] != '_'){
                    return false;
                }
            }else if(chars_target[right] == 'L'){
                for(int k = left; k < chars_start.length; k++){
                    if(chars_start[k] == 'L'){
                        chars_start[k] = '_';
                        chars_start[left] = 'L';
                        break;
                    }
                    if(chars_start[k] == 'R'){
                        return false;
                    }
                }
            }else if(chars_target[right] == 'R'){
                for(int k = left; k < chars_start.length; k++){
                    if(chars_start[k] == 'L'){
                        chars_start[k] = '_';
                        chars_start[left] = 'L';
                        break;
                    }
                    if(chars_start[k] == 'R'){
                        break;
                    }
                }
            }
            right++;
            left++;
        }
        return true;
    }

    private void remove(char[] chars_start, int left) {
        if(left >= chars_start.length - 1){
            return;
        }
        if(chars_start[left + 1] == '_'){
            chars_start[left + 1] = 'R';
            chars_start[left] = '_';
            return;
        }
        if(chars_start[left + 1] == 'R'){
            remove(chars_start, left + 1);
            if(chars_start[left + 1] == '_'){
                remove(chars_start, left);
            }
            return;
        }
        if(chars_start[left + 1] == 'L'){
            return;
        }
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.canChange("_L__R__R_", "L______RR"));
    }
}
