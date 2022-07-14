package com.company.Everyday;

public class minMutation {
    int ret = 20;

    public int minMutation(String start, String end, String[] bank) {
        boolean flag = true;
        for(int i = 0; i < bank.length; i++){
            if(end.equals(bank[i])){
                flag = false;
                break;
            }
        }
        if(flag){
            return -1;
        }
        boolean[] mark = new boolean[bank.length];
        dfs(start, end, bank, mark, 0);
        return ret == 20 ? -1 : ret;
    }

    public void dfs(String start, String end, String[] bank, boolean[] mark, int count){
        if(check(start, end)){
            ret = Math.min(ret, count + 1);
            return;
        }
        for(int i = 0; i < bank.length; i++){
            if(!mark[i] && check(start, bank[i])){
                mark[i] = true;
                dfs(bank[i], end, bank, mark, count + 1);
                mark[i] = false;
            }
        }
    }

    public boolean check(String start, String end){
        int count = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) != end.charAt(i)){
                count++;
            }
        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        minMutation minMutation = new minMutation();
        minMutation.minMutation("AAAAAAAA","CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"});
    }
}
