package algorithm;

import java.util.ArrayDeque;

/**
 * Created by maliu2 on 11/13/15.
 */
public class MaximumSlidingWindow {
    public MaximumSlidingWindow(){}

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<k; i++){
            if(deque.isEmpty())     deque.addFirst(i);
            else                    addOne(deque, nums, i);
        }
        int index = 0;
        index++;

        for(; index < result.length; index++){
            result[index-1] = nums[deque.getFirst()];
            addOne(deque, nums, index-1+k);
            if(deque.getFirst() == index - 1)   deque.removeFirst();
        }
        result[index-1] = nums[deque.getFirst()];
        return result;
    }

    public void addOne(ArrayDeque<Integer> deque, int[] nums, int i){
        while(nums[deque.getLast()] <= nums[i]){
            deque.removeLast();
            if(deque.isEmpty()) break;
        }
        deque.addLast(i);
        return;
    }

    public static void main(String[] args){
        int[] result = new MaximumSlidingWindow().maxSlidingWindow(new int[]{7, 2, 4}, 2);
        for(int i : result){
            System.out.println(i);
        }
        return;
    }
}
