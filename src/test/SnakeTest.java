package test;

import java.util.Scanner;

/**
 * Created by xin on 2016/4/5.
 */

/*
腾讯笔试，蛇形数组
 */
public class SnakeTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            fun(n);
        }
    }
    private static void fun(int n) {
        int[][] arr = new int[n][n];
        int num = 0;
        int x = 0, y = 0;
        while (num<n*n){
            while (y<n && arr[x][y]==0){
                arr[x][y++] = ++num;
            }
            x++; y--;
            while (x<n && arr[x][y]==0){
                arr[x++][y] = ++num;
            }
            x--; y--;
            while (y>=0 && arr[x][y]==0){
                arr[x][y--] = ++num;
            }
            x--; y++;
            while (x>0 && arr[x][y]==0){
                arr[x--][y] = ++num;
            }
            x++; y++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
