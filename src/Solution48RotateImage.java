/**
 You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 **/


public class Solution48RotateImage {

    // if do not consider allocate limitation,we copy one row to last column
    static int[][] solutionOne(int[][] array){
        int col = array[0].length;
        int row = array.length;
        int newCol = row;
        int newRow = col;
        int [][]solution = new int[newRow][newCol];
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
               solution[j][col-1-i]=array[i][j];
            }
        }
        return solution;
    }

    // do not allocate another matrix
    static void solutionTwo(int[][] array){
        int N = array.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = array[i][j];
                array[i][j] = array[N - j - 1][i];
                array[N - j - 1][i] = array[N - i - 1][N - j - 1];
                array[N - i - 1][N - j - 1] = array[j][N - i - 1];
                array[j][N - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] a = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        solutionTwo(a);
    }
}
