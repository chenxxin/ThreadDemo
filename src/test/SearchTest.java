package test;

/**
 * Created by xin on 2016/3/18.
 */
public class SearchTest {
    public static void main(String[] args) {
//        int[] a = {12,23,26,37,54,60,68,75,82,96};
        int[] a = {12,23,26,37,54};
        int[] b = {60,68,75,82,96};

    }

    //顺序查找
    public static int sequenceSearch(int[] a, int x){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x){
                return i;
            }
        }
        return -1;
    }

    //二分查找/折半查找
    public static int binarySearch(int[] a, int x){
        int n = a.length;
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if (a[mid] == x){
                return mid;
            }else if (a[mid] > x){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

}
