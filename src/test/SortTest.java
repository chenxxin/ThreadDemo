package test;/*
排序算法
 */

public class SortTest {
    public static void main(String[] args) throws InterruptedException {
        int[] a = {45,53,18,36,72,30,48,93,15};
        heepSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

    //直接插入排序
    public static void insertSort(int[] a){
        int n = a.length;
        for (int i = 1; i <= n-1; i++) {
            int x = a[i];
            for (int j = i-1; j >= 0; j--) {
                if (x<a[j]){
                    a[j+1] = a[j];
                    a[j] = x;
                }
            }
        }
    }

    //直接选择排序
    public static void selectSort(int[] a){
        int n = a.length;
        for (int i = 0; i <= n-2; i++) {
            int k = i;
            for (int j = i+1; j <= n-1; j++) {
                if (a[j]<a[k]){
                    k = j;
                }
            }
            int temp = a[i];  a[i] = a[k];  a[k] = temp;
        }
    }

    //堆排序
    public static void heepSort(int[] a){
        int n = a.length;
        //建立初始堆
        for (int i=n/2-1;i>=0;i--){
            sift(a,n,i);
        }
        //进行n-1次循环，完成堆排序
        for (int i = 1; i <= n-1; i++) {
            int temp = a[0]; a[0] = a[n-i]; a[n-i] = temp;
            sift(a,n-i,0);
        }
    }

    //堆排序--构成初始堆
    public static void sift(int[] a, int n, int i){
        int x = a[i];
        int j = 2*i+1;
        while(j<= n-1){
            if (j<n-1 && a[j]<a[j+1]){
                j += 1;
            }
            if (a[i]<a[j]){
                a[i] = a[j];
                a[j] = x;
                i = j;
                j = 2*i+1;
            }else {
                break;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] a){
        int n = a.length;
        for (int i = 1; i <= n-1; i++) {
            boolean flag = false;
            for (int j = n-1; j >= i; j--) {
                if (a[j]<a[j-1]){
                    int temp = a[j]; a[j] = a[j-1]; a[j-1] = temp;
                    flag = true;
                }
            }
            if (flag==false){
                break;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] a){
        quckRecursion(a, 0, a.length-1);
    }

    //快速排序--对数组a中下标从s到t区间内的元素进行递归排序
    public static void quckRecursion(int[] a, int s, int t){
        int j = partition(a, s, t);
        if (s<j-1){ quckRecursion(a, s, j-1);}
        if (j+1<t){ quckRecursion(a, j+1, t);}
    }

    //快速排序--对数组a中下标从s到t区间内的元素进行一次划分，返回中间位置
    public static int partition(int[] a, int s, int t){
        int i = s, j = t;
        int x = a[i++];
        while (i<=j){
            while (i<=j && a[i]<x){ i++;}
            while (i<=j && a[j]>x){ j--;}
            if (i<j){
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++;j--;
            }
        }
        a[s] = a[j]; a[j] = x;
        return j;
    }

    //归并排序
    public static void mergeSort(int[] a){
        int n = a.length;
        int[] r = new int[n];
        int len = 1;   //需要归并的有序表的长度
        while (len<n){
            mergePass(a,r,n,len);  //把a归并到r中
            len*=2;
            mergePass(r,a,n,len);  //把r归并回a中
            len*=2;
        }
    }

    //归并排序---进行一趟二路归并
    public static void mergePass(int[] a, int[] r, int n, int len){
        int p = 0;
        //两两归并长度均为len的有序表
        while (p+2*len-1<=n-1) {
            twoMerge(a, r, p, p+len-1, p+2*len-1);
            p+=2*len;
        }
        if (p+len-1<n-1){     //归并最后两个长度不等的有序表
            twoMerge(a, r, p, p+len-1, n-1);
        }else {               //把剩下的最后一个有序表复制到r中
            for (int i = p; i <= n-1; i++) {
                r[i] = a[i];
            }
        }
    }

    //归并排序---进行一次二路归并
    public static void twoMerge(int[] a, int[] r, int s, int m, int t){
        int i = s, j = m+1, k = s;
        while (i<=m && j<=t){
            if (a[i]<a[j]){
                r[k] = a[i]; i++; k++;
            }else {
                r[k] = a[j]; j++; k++;
            }
        }
        while (i<=m){
            r[k] = a[i];  i++; k++;
        }
        while (j<=t){
            r[k] = a[j];  j++; k++;
        }
    }
}
