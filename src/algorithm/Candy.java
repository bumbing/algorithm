package algorithm;

/**
 * Created by maliu2 on 10/14/15.
 */
public class Candy {
    public Candy(){}

    public int[] run(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] result = new int[length];

        for(int i=0; i<length; i++){
            if(i==0)    left[i] = 1;
            else{
                if(ratings[i] > ratings[i-1])
                    left[i] = left[i-1] + 1;
                else left[i] = 1;
             }
        }

        for(int i=length-1; i>=0; i--){
            if(i==length-1)    right[i] = 1;
            else{
                if(ratings[i] > ratings[i+1])
                    right[i] = right[i+1] + 1;
                else right[i] = 1;
            }
        }

        for(int i=0; i<length; i++){
            result[i] = Math.max(left[i], right[i]);
        }

        return result;
    }

    public static void main(String[] args){
        int[] input = {2, 1};
        Candy candy = new Candy();
        int[] result = candy.run(input);
        for(int number : result){
            System.out.println(number);
        }

    }
}
