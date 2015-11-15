package algorithm;

import java.util.*;

/**
 * Created by maliu2 on 10/14/15.
 */
public class ScambleNumber {
    public ScambleNumber(){

    }

    public int test(int head, int tail){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> scamble = new HashSet<>();
        for(int i=head; i<=tail; i++){
            int temp = SortNumber(i);
            if(set.contains(temp)){
                scamble.add(temp);
            }else{
                set.add(temp);
            }
        }

        return scamble.size();
    }

    private int SortNumber(int input){
        if(input == 0)
            return input;
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        while(input!=0){
            int tmp = input % 10;
            numbers.add(tmp);
            input /= 10;
        }
        Collections.sort(numbers);
        for(int i=0; i<numbers.size(); i++){
            int number = numbers.get(i);
            if(number != 0){
                result += number;
                numbers.remove(i);
                break;
            }
        }

        for(int number:numbers){
            result = (result * 10) + number;
        }

        return result;
    }

    public static void main(String[] args){
        int head = 1000;
        int tail = 9999;
        ScambleNumber testclass = new ScambleNumber();
        System.out.println(testclass.test(head, tail));
    }
}
