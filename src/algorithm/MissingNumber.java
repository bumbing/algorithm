package algorithm;

/**
 * Created by maliu2 on 11/10/15.
 */
public class MissingNumber {
    public MissingNumber(){}

    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(nums[i] == i || nums[i] < 0 || nums[i] >= nums.length){
                i++;
            }else if(nums[nums[i]] == nums[i]){
                i++;
            }else{
                swap(nums, i);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i)    return i;
        }

        return nums.length;
    }

    public void swap(int[] nums, int index){
        int temp = nums[nums[index] ];
        nums[nums[index]] = nums[index];
        nums[index] = temp;
        return;
    }
}
