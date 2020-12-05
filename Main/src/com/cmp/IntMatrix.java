package com.cmp;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class IntMatrix {
    private static int[] lineMatrix;
    private static int n;
    private static int m;

    public IntMatrix(int[] lineMatrix, int n, int m) {

        if (n < 0 || m < 0 || lineMatrix.length != n * m)
            throw new IllegalArgumentException();
        this.lineMatrix = lineMatrix.clone();
        this.n = n;
        this.m = m;
    }
    public static TableModel fillMatrixByRandomValues(int rows, int cols) {
        Random random = new Random();
        if(rows > n | cols > m | rows < n | cols < m) {
            throw new IndexOutOfBoundsException();
        }
        int[][] arraylist = new int[rows][cols];
        Object[][] arrlist = new String[rows][cols];
        Object[] arrcols = new String[cols];
        int k =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arraylist[i][j] = random.nextInt(1000);
                arrlist[i][j]=Integer.toString(arraylist[i][j]);
                lineMatrix[k++] = arraylist[i][j];
            }
        }
        return new DefaultTableModel(arrlist,arrcols);
    }
    public static TableModel gradientMatrix(int rows,int cols,int sort){
        int k = 0;
        int[][] arraylist = new int [rows][cols];
        int[] rowMatrix = new int [cols];
        int[] colMatrix = new int [rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0;j < cols; j++) {
                arraylist[i][j] = lineMatrix[k++];
            }
        }
        for(int i = 0;i < rows; i++){
            k = 0;
            for(int j = 0 ; j < cols;j++){
                rowMatrix[k] = arraylist[i][j];
                k++;
            }
            k--;
            switch(sort){
                case 1: {
                    QuickSort.sortArray(rowMatrix);
                    break;
                }
                case 2:{
                    SelectionSort.sortArray(rowMatrix);
                    break;
                }
                case 3:{
                    MergeSort.sortArray(rowMatrix);
                    break;
                }
                case 4:{
                    InsertionSort.sortArray(rowMatrix);
                    break;
                }
                case 5:{
                    BubbleSort.sortArray(rowMatrix);
                    break;
                }
            }
            for(int j = k; j >= 0; j--){
                arraylist[i][j]=rowMatrix[k];
                k--;
            }
            k++;
            for(int j = 0 ;j < rows; j++){
                colMatrix[k] = arraylist[j][i];
                k++;
            }
            k--;
            switch(sort){
                case 1: {
                    QuickSort.sortArray(colMatrix);
                    break;
                }
                case 2:{
                    SelectionSort.sortArray(colMatrix);
                    break;
                }
                case 3:{
                    MergeSort.sortArray(colMatrix);
                    break;
                }
                case 4:{
                    InsertionSort.sortArray(colMatrix);
                    break;
                }
                case 5:{
                    BubbleSort.sortArray(colMatrix);
                    break;
                }
            }
            for(int j = k;j >= 0; j--){
                arraylist[j][i] = colMatrix[k];
                k--;
            }
        }
        Object[][] arrlist = new String[rows][cols];
        Object[] arrcols = new String[cols];
        k = 0;
        for(int i = 0;i < rows; i++){
            for(int j = 0;j < cols; j++){
                lineMatrix[k++] = arraylist[i][j];
                arrlist[i][j] = Integer.toString(arraylist[i][j]);
            }
        }
        return new DefaultTableModel(arrlist,arrcols);

    }
}
