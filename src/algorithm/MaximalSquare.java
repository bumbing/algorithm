package algorithm;

/**
 * Created by maliu2 on 11/17/15.
 */
public class MaximalSquare {
    public MaximalSquare(){}

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int result = 0;
        int[][] square = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int temp = 0;
                if(matrix[i][j] == '0'){
                    square[i][j] = 0;
                }else{
                    temp = Math.min((i!=0)?square[i-1][j]:0, (j!=0)?square[i][j-1]:0);
                    temp = Math.min(temp, (i!=0 && j!=0)?square[i-1][j-1]:0);
                    square[i][j] = temp + 1;
                }
                result = Math.max(result, square[i][j]);
            }
        }

        return result * result;
    }

    public static void main(String[] args){
        char[][] matrix = {{'1', '1', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));

    }
}
