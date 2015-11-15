package algorithm;

/**
 * Created by maliu2 on 10/29/15.
 */
public class MoveZeros {
    public MoveZeros(){}
    public void moveZeroes(int[] nums) {
        int lead = 0;
        int tail = 0;
        while(lead < nums.length){
            if(nums[lead] != 0){
                nums[tail] = nums[lead];
                tail ++;
            }
            lead++;
        }
        while(tail < nums.length){
            nums[tail] = 0;
            tail++;
        }
        return;
    }
}
