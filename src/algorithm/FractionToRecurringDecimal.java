package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maliu2 on 11/11/15.
 */
public class FractionToRecurringDecimal {
    public FractionToRecurringDecimal(){}

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> quotient = new HashMap<>();

        if(!same(numerator, denominator))   result.append('-');
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);

        result.append(Long.toString(numeratorL / denominatorL));

        numeratorL %= denominatorL;
        if(numeratorL != 0) result.append('.');
        int index = result.length();

        while(!quotient.containsKey(numeratorL)){
            if(numeratorL == 0)  return result.toString();
            quotient.put(numeratorL, index);
            index++;
            numeratorL *= 10;
            result.append(Long.toString(numeratorL / denominatorL));
            numeratorL %= denominatorL;

        }

        result.insert(quotient.get(numeratorL), "(" );
        result.append(")");
        return result.toString();
    }

    public boolean same(int a, int b){
        if(a < 0 && b > 0)  return false;
        if(a > 0 && b < 0)  return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
    }
}
