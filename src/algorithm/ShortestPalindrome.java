package algorithm;

/**
 * Created by maliu2 on 11/4/15.
 */
public class ShortestPalindrome {
    public ShortestPalindrome(){}

    public String shortestPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            int temp_head = head;
            int temp_tail = tail;
            while(temp_head < temp_tail){
                if(s.charAt(temp_head) != s.charAt(temp_tail))  break;
                else{
                    temp_head++;
                    temp_tail--;
                }
            }
            if(temp_head >= temp_tail)  break;
            else{
                tail--;
            }
        }
        int temp = s.length() - 1;
        StringBuilder result = new StringBuilder();
        while(temp > tail){
            result.append(s.charAt(temp));
            temp--;
        }
        return result.append(s).toString();
    }

    public static void main(String[] args){
        System.out.println(new ShortestPalindrome().shortestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
