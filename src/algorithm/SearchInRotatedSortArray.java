package algorithm;

/**
 * Created by maliu2 on 11/14/15.
 */
public class SearchInRotatedSortArray {
    public SearchInRotatedSortArray(){}

    public int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int mid;
        while(head + 1 < tail){
            mid = (head + tail) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[head] < nums[tail]){
                if(nums[mid] < target)  head = mid + 1;
                else    tail = mid - 1;
            }else if(nums[mid] > nums[head]){
                if(nums[mid] > target && nums[head] <= target){
                    tail = mid - 1;
                }else{
                    head = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[tail] >= target){
                    head = mid + 1;
                }else{
                    tail = mid - 1;
                }
            }
        }
        if(nums[head] == target)    return head;
        else if(nums[tail] == target)   return tail;
        else return -1;
    }


    public static void main(String[] args){
        System.out.println(new SearchInRotatedSortArray().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 5));
    }
}
