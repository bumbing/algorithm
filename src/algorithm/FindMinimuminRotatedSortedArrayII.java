package algorithm;

/**
 * Created by maliu2 on 11/15/15.
 */
public class FindMinimuminRotatedSortedArrayII {
    public FindMinimuminRotatedSortedArrayII(){}

    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    public int findMinHelper(int[] nums, int head, int tail){
        if(head == tail)    return nums[head];
        int mid = (head + tail) / 2;
        if(nums[mid] == nums[head] && nums[mid] == nums[tail])  return Math.min(findMinHelper(nums, head, mid), findMinHelper(nums, mid+1, tail));
        else if(nums[head] < nums[tail]){
            return nums[head];
        }else if(nums[head] <= nums[mid]){
            return findMinHelper(nums, mid+1, tail);
        }else   return findMinHelper(nums, head, mid);
    }

    //reference
    public int findMin2(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
            }
        }
        return nums[l];
    }
}
