package algorithm;

import static java.lang.Math.sqrt;

/**
 * Created by maliu2 on 11/17/15.
 */
public class PerfectSquare {
    public PerfectSquare(){}

    public int numSquares(int n) {
        int[] result = new int[n+1];
        for(int i = 0; i < result.length; i++)  result[i] = i;
        for(int i = 0; i < result.length; i++){
            for(int j = 1; i + j * j <= n; j++) result[i + j * j] = Math.min(result[i] + 1, result[i + j * j]);
        }
        return result[n];
    }

    //public int numSquares1(int n) {
    //        while (n % 4 == 0) n /= 4;
    //        if (n % 8 == 7) return 4;
    //        for (int a = 0; a * a <= n; ++a) {
    //            int b = sqrt(n - a * a);
    //            if (a * a + b * b == n) {
    //                return !!a + !!b;
    //            }
    //        }
    //        return 3;
    //    }
    //}

    //public static void main(String[] args){
    //    System.out.println(new PerfectSquare().numSquares(12));
    //}
}
