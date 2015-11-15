package algorithm;

/**
 * Created by maliu2 on 11/3/15.
 */
public class LongestValidParentheses {
    public LongestValidParentheses(){}

    public int longestValidParentheses(String s) {
        int result = 0;
        int temp = 0;
        int[] valid = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            if(i != 0)  temp +=  (s.charAt(i)=='(') ? -1 : 1;
            for(int j = i; j < s.length(); j++){
                if(i == 0){
                    if(j == 0)  valid[j] = 0;
                    else valid[j] = valid[j-1];

                    //valid[i] = valid[i-1] + (s.charAt(i)=='\(') ?1:-1;
                    if(s.charAt(j) == '(' )     valid[j]++;
                    else    valid[j]--;
                }
                if(valid[i] == temp)    result = Math.max(result, j - i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String input = ")(";
        System.out.println(new LongestValidParentheses().longestValidParentheses(input));
    }
}
