package com.company.competition.Week_284;

public class DigArtifacts {

    boolean[][] flag = new boolean[1000][1000];

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int result = 0;
        for (int[] ints : dig) {
            flag[ints[0]][ints[1]] = true;
        }
        for (int[] artifact : artifacts) {
            if(check(artifact)){
                result++;
            }
        }
        return result;
    }

    public boolean check(int[] artifact){
        for (int i = artifact[0]; i <= artifact[2]; i++){
            for (int j = artifact[1]; j <= artifact[3]; j++){
                if (!flag[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
