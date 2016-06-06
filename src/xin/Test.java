package xin;

/**
 * Created by xin on 2016/5/13.
 */
public class Test {
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Coordinate c = find(arr,4,4,5);
        if (c!=null){
            System.out.println("arr["+c.getRow()+"]["+c.getColumn()+"]");
        }else {
            System.out.println("not found");
        }
    }

    //二维数组中的查找
    public static Coordinate find(int[][] arr, int row, int column, int x){
        if (arr!=null && row>0 && column>0){
            int i=0, j=column-1;
            while (i<row && j>=0){
                if (arr[i][j]==x){
                    return new Coordinate(i,j);
                }else if (arr[i][j]>x){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return null;
    }
}

class Coordinate{
    private int row;
    private int column;

    public Coordinate() {
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
