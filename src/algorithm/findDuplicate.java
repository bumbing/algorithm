package algorithm;

/**
 * Created by maliu2 on 10/20/15.
 */
public class findDuplicate {
    public findDuplicate(){}

    public int findDuplicate1(int[] nums) {
        int head = 1;
        int tail = nums.length - 1;
        int temp = 0;
        while(head < tail){
            if( nums[temp] < head || nums[temp] > tail){
                temp++;
                continue;
            }
            int smaller = 0;
            int bigger = 0;
            for(int index = 0; index < nums.length; index++){
                if(nums[index] < head || nums[index] > tail){
                    continue;
                }else if(nums[index] == nums[temp] && index != temp){
                    return nums[index];
                }else if(nums[index] > nums[temp]){
                    bigger++;
                }else{
                    smaller++;
                }
            }
            if(smaller > nums[temp] - head){
                tail = nums[temp] - 1;
            }else{
                head = nums[temp] + 1;
            }
            temp++;
        }
        return head;
    }

    public static void main(String[] args){
        int[] input = {1, 2, 2};
        System.out.println(new findDuplicate().findDuplicate1(input));

    }
}
