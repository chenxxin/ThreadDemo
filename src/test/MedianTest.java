package test;

import java.util.Arrays;

/**
 * Created by xin on 2016/3/14.
 */
public class MedianTest {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11};
        int[] b = {2};
        int number = new MedianTest().findK(a, 6, b, 1, 5);
        System.out.println(number);

    }
    public int findMedianEqualLength(int a[] , int b[] , int n){
        if(n == 1){
            return a[0] > b[0] ? b[0] : a[0];
        }
        int mid = (n-1)/2;   //奇数就取中间的，偶数则取坐标小的
        int len = n/2;  // len：将要去掉的长度
        if(a[mid] == b[mid]){
            return a[mid];
        }
        else if(a[mid] < b[mid]){
            int[] a2 = Arrays.copyOfRange(a, len, n);
            return findMedianEqualLength(a2, b, n-len);    //新数组的长度为 n-len
        }else{
            int[] b2 = Arrays.copyOfRange(b,len, n);
            return findMedianEqualLength(a, b2, n-len);
        }
    }

    public int findMedianUnequalLength(int a[] ,int n1, int b[] , int n2){
        int m1 = (n1-1)/2;
        int m2 = (n2-1)/2;

        if (n1 == 1){
            int m = n2/2;
            if (a[0]>=b[m]) return b[m];
            else if (a[0]<b[m-1]) return b[m-1];
            else return a[0];
        }else if (n2 == 1){
            return findMedianUnequalLength(b,1,a,n1);
        }
        int len = n1<n2 ? n1/2 : n2/2;   //len：将要去掉的长度
        if(a[m1] == b[m2])
            return a[m1];
        else if(a[m1] < b[m2]){
            int[] a2 = Arrays.copyOfRange(a, len, n1);
            return findMedianUnequalLength(a2,n1-len, b,n2-len);  //新数组的长度为 n-len
        }else{
            int[] b2 = Arrays.copyOfRange(b,len,n2);
            return findMedianUnequalLength(a, n1-len, b2,n2-len);
        }
    }

    public int findK(int a[] ,int n1, int b[] , int n2, int k){
        if (n1==1){
            if (a[0]>b[k-1]) return b[k-1];
            else if (a[0]<b[k-2]) return b[k-2];
            else return a[0];
        }else if (n2==1){
            return findK(b,1,a,n1,k);
        }

        if (a[n1/2]<=b[n2/2]){
            if (k<=(n1+n2)/2){
                return findK(a,n1,b,n2-n2/2,k);
            }else {
                int[] a2 = Arrays.copyOfRange(a,n1/2,n1);
                return findK(a2,n1-n1/2,b,n2,k-n1/2);
            }
        }else {
            return findK(b,n2,a,n1,k);
        }
    }
}



