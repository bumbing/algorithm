package algorithm;

/**
 * Created by maliu2 on 11/10/15.
 */
public class FirstMissingPositive {
    public FirstMissingPositive(){}

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length){
                i++;
            }else if(nums[nums[i] - 1] == nums[i]){
                i++;
            }else{
                swap(nums, i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)    return i + 1;
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int index){
        int temp = nums[nums[index] - 1];
        nums[nums[index] - 1] = nums[index];
        nums[index] = temp;
        return;
    }

    public static void main(String[] args){
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {1, 1}) + 1);
    }
}
