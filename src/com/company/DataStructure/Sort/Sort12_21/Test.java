package com.company.DataStructure.Sort.Sort12_21;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        BubbleSort sortA = new BubbleSort();
        sortA.sort(a);
        System.out.println("BubbleSort:" + "   " + Arrays.toString(a));


        int[] c = new int[]{2,3,1,5,4};
        InsertSort sortC = new InsertSort();
        sortC.sort(c);
        System.out.println("InsertSort:" + "   " + Arrays.toString(c));


        int[] f = new int[]{2,3,1,5,4};
        SelectSort sortF = new SelectSort();
        sortF.sort(f);
        System.out.println("SelectSort:" + "   " + Arrays.toString(f));


        int[] e = new int[]{2,3,1,5,4};
        QuickSort sortE = new QuickSort();
        sortE.sort(e, 0, a.length - 1);
        System.out.println("QuickSort:" + "   " + Arrays.toString(e));



        int[] g = new int[]{2,3,1,5,4};
        ShellSort sortG = new ShellSort();
        sortG.sort(g);
        System.out.println("ShellSort:" + "   " + Arrays.toString(g));

        int[] h = new int[]{2,3,1,5,4};
        BinaryInsertSort sortH = new BinaryInsertSort();
        sortH.sort(h);
        System.out.println("BinaryInsertSort:" + "   " + Arrays.toString(g));
        /*
        int[] b = new int[]{2,3,1,5,4};
        HeapSort sortB = new HeapSort();
        sortB.sort(b);
        System.out.println("HeapSort:" + "   " + Arrays.toString(b));


        int[] d = new int[]{2,3,1,5,4};
        MergeSort sortD = new MergeSort();
        sortD.sort(d);
        System.out.println("MergeSort:" + "   " + Arrays.toString(d));


         **/
    }
}
