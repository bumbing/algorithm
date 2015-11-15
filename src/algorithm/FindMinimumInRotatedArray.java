package algorithm;

import sun.jvm.hotspot.tools.FinalizerInfo;

/**
 * Created by maliu2 on 11/14/15.
 */
public class FindMinimumInRotatedArray {
    public FindMinimumInRotatedArray(){}

    public int findMin(int[] nums) {
        int head = 0;
        int tail = nums.length-1;
        int mid;
        while(head + 1 < tail){
            mid = (head + tail) /2;
            if(nums[tail] > nums[head]){
                return nums[head];
            }else if(nums[mid] > nums[head]){
                head = mid+1;
            }else if(nums[mid] < nums[tail]){
                tail = mid;
            }
        }
        return Math.min(nums[head], nums[tail]);
    }

    public static void main(String[] args){
        System.out.println(new FindMinimumInRotatedArray().findMin(new int[] {2, 3, 4, 5, 6, 1}));
    }
}
