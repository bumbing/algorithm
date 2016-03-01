package algorithm;

/**
 * Created by maliu2 on 2/16/16.
 */
public class PatchingArray {
    public PatchingArray() {
    }

    public int minPatches(int[] nums, int n) {
        int count = 0, patch_numbers = 0;
        int i = 0;
        while(count < n && count >= 0){
            //count >=0 means it haven't been overflowed
            if(i == nums.length || count+1 < nums[i]){
                count += count + 1;
                patch_numbers++;
            }
            else if(count+1 >= nums[i]){
                count += nums[i];
                i++;
            }

        }
        return patch_numbers;
    }
}