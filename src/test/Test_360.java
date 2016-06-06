package test;/*
2016年360笔试题
 */

import java.util.Scanner;

public class Test_360 {
    public static void fun_360_2(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String str = scanner.next();
            char[] ch = new char[n];
            for (int i = 0; i < n; i++) {
                ch[i] = str.charAt(i);
            }
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                char c = scanner.next().charAt(0);
                ch[x-1] = c;
                System.out.println(f(ch));
            }

        }
    }

    private static int f(char[] ch) {
        int count = 0;
        for (int i = 0; i < ch.length-1; i++) {
            if (ch[i]=='.' && ch[i+1]=='.'){
                count++;
            }
        }
        return count;
    }

    public static void fun_360_1(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int b = scanner.nextInt();
            int num = b-1<n-b?b+1:b-1;
            int result = num==0?1:num;
            System.out.println(result);
        }
    }
}
