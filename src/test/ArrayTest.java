package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {1,3,5,5,7,9};
        int[] b = {2,3,4,5,6,8,10};
        System.out.println(union(a,b));
    }
    //两个有序数组的交集
    public static List intersection(int[] a,int[] b){
        List list = new ArrayList();
        int i = 0, j = 0;
        while(i<a.length && j<b.length){
            if (a[i]<b[j]){
                i++;
            }else if (a[i]>b[j]){
                j++;
            }else {
                list.add(a[i]);
                i++; j++;
            }
        }
        return list;
    }
    //两个有序数组的并集
    public static List union(int[] a, int[] b){
        List list = new ArrayList();
        int i = 0, j = 0;
        while (i<a.length && j<b.length){
            if (a[i]<b[j]){
                list.add(a[i++]);
            }else if(a[i]>b[j]){
                list.add(b[j++]);
            }else {
                list.add(a[i]);
                i++; j++;
            }
        }
        while (i<a.length){
            list.add(a[i++]);
        }
        while (j<b.length){
            list.add(b[j++]);
        }
        return list;
    }

    public static void test(int[] a, int[] b){
        int end = a.length;
        boolean flag;
        for (int i = 0; i < end; ) {
            flag = false;
            for (int j = i; j < b.length; j++) {
                if (b[j]==a[i]){
                    flag = true;
                    int temp = b[i]; b[i] = b[j]; b[j] = temp;
                    break;
                }
            }
            if (flag){
                i++;
            }else{
                int temp = a[i]; a[i] = a[--end]; a[end] = temp;
            }
        }
        System.out.println("交集为：");
        for (int i = 0; i < end; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n并集为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        for (int i = end; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }
}
