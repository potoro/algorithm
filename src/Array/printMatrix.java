package Array;

import java.util.ArrayList;
public class printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
       if(matrix==null||matrix.length==0) return list;
       
       int cols = matrix[0].length;
       int rows = matrix.length;
        
       for(int start=0; rows> start*2 && cols > start*2; start++){
           print(matrix,rows,cols,start,list);
       }
       return list;
    }
    public static void print(int [][] matrix, int rows,int cols,int start,ArrayList<Integer> list){
        int EndX= cols-1-start;
        int EndY = rows-1-start;
       // if(EndX==start && EndY==start) list.add(matrix[start][start]);
        if(EndX >= start){
            for(int i=start; i<= EndX; i++)
                list.add(matrix[start][i]);
        }
        if(EndY > start){
            for(int i= start+1; i<=EndY; i++){
                list.add(matrix[i][EndX]);
            }
        }
        if(EndX > start && EndY > start){
            for(int i=EndX-1; i>=start; i--){
                  list.add(matrix[EndY][i]);
            }
        }
        if(EndX > start && EndY > (start+1)){
            for(int i = EndY-1; i>start; i--){
                list.add(matrix[i][start]);
            }
        }
    }
    
    public static void main(String args[]){
    int [][]matrix = new int[3][];
	    matrix[0] = new int[]{1,2,3,4};
	    matrix[1] = new int[]{5,6,7,8};
	    matrix[2] = new int[]{9,10,11,12};
	    int[][]matrix2 = new int[1][];
	    matrix2[0] = new int[]{1,2,3,4,5};
	    printMatrix(matrix2);
    }
}