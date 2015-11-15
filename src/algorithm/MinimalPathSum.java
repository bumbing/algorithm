package algorithm;

/**
 * Created by maliu2 on 11/9/15.
 */
public class MinimalPathSum {
    public MinimalPathSum(){}

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        if (x == 0) return 0;
        int y = grid[0].length;
        if (y == 0) return 0;

        int[][] result = new int[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i == 0 && j == 0){
                    result[i][j] = grid[i][j];
                }else if(i == 0){
                    result[i][j] = grid[i][j] + result[i][j-1];
                }else if(j == 0){
                    result[i][j] = grid[i][j] + result[i-1][j];
                }else{
                    result[i][j] = grid[i][j] + Math.min(result[i][j-1], result[i-1][j]);
                }
            }
        }
        return result[x-1][y-1];
    }
}
