package algorithm;

/**
 * Created by maliu2 on 10/29/15.
 */
public class ContainerWithMostWater {
    public ContainerWithMostWater(){}

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left < right){
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if(height[left] >= height[right])   right --;
            else left++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new ContainerWithMostWater().maxArea(input));

    }
}
