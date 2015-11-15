package algorithm;

/**
 * Created by maliu2 on 10/29/15.
 */
public class EditDistance {
    public EditDistance(){}
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0)  return Math.max(word1.length(), word2.length());
        int[][] result = new int[word1.length()][word2.length()];

        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i == 0)  result[i][j] = j;
                else if(j == 0)  result[i][j] = i;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) result[i][j] = result[i-1][j-1];
                else result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) + 1;
            }
        }

        return result[word1.length()-1][word2.length()-1];
    }

    public static void main(String[] args){
        System.out.println(new EditDistance().minDistance("a", "a"));

    }
}
