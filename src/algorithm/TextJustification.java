package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maliu2 on 11/16/15.
 */
public class TextJustification {
    public TextJustification(){}

    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0)   return new ArrayList<String>();
        else if(maxWidth == 0){
            List<String> result = new ArrayList<String>();
            result.add("");
            return result;
        }
        int index = 0;
        List<String> result = new ArrayList<String>();
        while(index < words.length){
            int next = index;
            int length = 0;
            StringBuilder temp = new StringBuilder();
            while(next < words.length){
                if(next == index){
                    length += words[next].length();
                    next++;
                }else if(next != index){
                    if(length + words[next].length() + 1 <= maxWidth){
                        length += words[next].length()+1;
                        next++;
                    }
                    else break;
                }
            }
            int blank = (maxWidth - length + 1) / (next - index);
            int rest = (maxWidth - length + 1) % (next - index);
            for(int i = index; i < next; i++){
                temp.append(words[i]);
                for(int j = blank; j > 0; j--)  temp.append(' ');
                if(i - index < rest)    temp.append(' ');
            }
            result.add(temp.toString());
            index = next;
        }
        return result;
    }

    public static void main(String[] args){
        for(String temp: new TextJustification().fullJustify(new String[] {""}, 2)){
            System.out.println(temp);
        }
    }
}
