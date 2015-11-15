package algorithm;

/**
 * Created by maliu2 on 11/9/15.
 */
public class DungeonGame {
    public DungeonGame(){}

    public int calculateMinimumHP(int[][] dungeon) {
        //since we can't divide it to DP from dungeon[0][0] bottom up, we will choose dungeon[max][max] to bottom up, which satisfies 1. Independent problem, 2. Sub-optimal problem.
        //thinking in another way, if there is a big positive value, it can cover all previous values in way2, but not way1.
        if(dungeon.length == 0) return 0;
        else if(dungeon[0].length == 0)  return 0;
        int[][] result = new int[dungeon.length][dungeon[0].length];
        for(int i = dungeon.length-1; i>=0; i--){
            for(int j = dungeon[0].length-1; j>=0; j--){
                if(i == dungeon.length-1 && j == dungeon[0].length-1){
                    result[i][j] = Math.max(0, 0 - dungeon[i][j]);
                }else if(j == dungeon[0].length-1){
                    result[i][j] = Math.max(0, result[i+1][j] - dungeon[i][j]);
                }else if(i == dungeon.length-1){
                    result[i][j] = Math.max(0, result[i][j+1] - dungeon[i][j]);
                }else{
                    result[i][j] = Math.max(0, Math.min(result[i][j+1] - dungeon[i][j], result[i+1][j] - dungeon[i][j]));
                }
            }
        }
        return result[0][0]+1;
    }
}
