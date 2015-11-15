package algorithm;

/**
 * Created by maliu2 on 11/14/15.
 */
public class DistinctSubsequence {
    public DistinctSubsequence(){}

    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int[][] result = new int[s.length()+1][t.length()+1];
        result[0][0] = 1;
        for(int i = 0; i < result.length - 1; i++){
            for(int j = 0; j < result[0].length; j++){
                if(j >= i + 1)  break;
                else if(s.length() - i < t.length() - j)    continue;
                else if(result[i][j] == 0)  continue;
                else if(j == t.length()){
                    result[i+1][j] += result[i][j];
                }
                else{
                    if(s.charAt(i) == t.charAt(j)){
                        result[i+1][j+1] += result[i][j];
                    }
                    result[i+1][j] += result[i][j];
                }
            }
        }
        return result[s.length()][t.length()];
    }
}
