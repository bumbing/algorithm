package algorithm;

/**
 * Created by maliu2 on 10/29/15.
 */
public class RemoveElement {
    public RemoveElement(){}
    public int removeElement(int[] nums, int val) {
        int result = nums.length;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                result--;
                right--;
            }
            else    left++;
        }
        return result;
    }
}
