package test;

/**
 * Created by xin on 2016/5/13.
 */
public class RhombusTest {
    public static void main(String[] args) {
        printSolid2(5);
    }
    //打印实心菱形块，n为边长，135797531
    public static void printSolid(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //打印实心菱形块，n为边长,123454321
    public static void printSolid2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //打印空心菱形块
    public static void printHollow(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j <= 2*i-3; j++) {
                System.out.print(" ");
            }
            if (i!=1){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j <= 2*i-3; j++) {
                System.out.print(" ");
            }
            if (i!=1){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
