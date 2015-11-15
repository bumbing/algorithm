package algorithm;

/**
 * Created by maliu2 on 10/29/15.
 */
public class TrappingRainWater {
    public TrappingRainWater(){}

        public int trap(int[] height) {
            int length = height.length;
            int result = 0;
            int[] left = new int[length];
            int[] right = new int[length];

            int highest = 0;
            for(int i = 0;i < length; i++){
                highest = Math.max(highest, height[i]);
                left[i] = highest;
            }

            highest = 0;
            for(int i = length-1;i >= 0; i--){
                highest = Math.max(highest, height[i]);
                right[i] = highest;
            }

            for(int i = 0;i < length; i++){
                result += Math.min(left[i], right[i]) - height[i];
            }
            return result;
        }

    public static void main(String[] args){
        int[] input = {2, 0, 2};
        System.out.println(new TrappingRainWater().trap(input));

    }
}
