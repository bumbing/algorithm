package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maliu2 on 11/11/15.
 */
public class MinimumWindowSubstring {
    public MinimumWindowSubstring(){}

    public String minWindow(String s, String t) {
        Map<Character, Integer> StringT = new HashMap<>();
        Map<Character, Integer> StringS = new HashMap<>();
        int headFin = 0;
        int tailFin = s.length();
        int head = 0, tail = 0;
        int count = 0;
        for(int i = 0; i < t.length(); i++){
            char tmp = t.charAt(i);
            if(StringT.containsKey(tmp)){
                StringT.put(tmp, StringT.get(tmp) + 1);
            }else{
                StringT.put(tmp, 1);
            }
        }
        if(StringT.containsKey(s.charAt(0))){
            count++;
            StringS.put(s.charAt(0), 1);
        }

        while(tail < s.length()){
            if(count == t.length() && head == tail){
                char temp = s.charAt(head);
                return Character.toString(temp);
            }else if(count == t.length() && head < tail){
                if(tail - head < tailFin - headFin){
                    headFin = head;
                    tailFin = tail;
                }

                if(StringT.containsKey(s.charAt(head))){
                    int temp = StringS.get(s.charAt(head));
                    if(temp <= StringT.get(s.charAt(head)) ){
                        count--;
                    }
                    StringS.put(s.charAt(head), temp - 1);
                }
                head++;

            }else if(tail < s.length() -1){
                tail++;
                if(StringT.containsKey(s.charAt(tail))){
                    if(StringS.containsKey(s.charAt(tail))){
                        int temp = StringS.get(s.charAt(tail));
                        count += StringT.get(s.charAt(tail)) > temp? 1 : 0;
                        StringS.put(s.charAt(tail), temp + 1);
                    }else{
                        StringS.put(s.charAt(tail), 1);
                        count++;
                    }
                }
            }else{
                break;
            }

        }
        if(tailFin == s.length()) return "";
        return s.substring(headFin, tailFin+1);
    }

    public static void main(String[] args){
        String result = new MinimumWindowSubstring().minWindow("aa", "aa");
        System.out.println(result);
    }
}
