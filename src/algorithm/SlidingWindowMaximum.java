package algorithm;

import java.util.ArrayDeque;

/**
 * Created by maliu2 on 10/30/15.
 */
public class SlidingWindowMaximum {
    public SlidingWindowMaximum(){}

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int index = 0;index < nums.length;index++){
            this.InsertNum(nums, index, deque, k);
            if(index >= k -1)  result[index - k +1] = nums[deque.getFirst()];
        }
        return result;
    }

    private void InsertNum(int[] nums, int index, ArrayDeque<Integer> deque, int k){
        if(deque.isEmpty()){
            deque.add(index);
        }else{
            while(!deque.isEmpty()){
                if(nums[index] < nums[deque.getLast()]) break;
                deque.pollLast();
            }
            deque.add(index);
            while(!deque.isEmpty()){
                if(deque.getFirst() > index - k + 1)   break;
                deque.poll();
            }
            if(index - k + 1 >=0 && nums[index - k + 1] > deque.getFirst())   deque.addFirst(index - k + 1);
        }
        return;
    }

    public static void main(String[] args){
        int[] result = new SlidingWindowMaximum().maxSlidingWindow(new int[]{9, 11}, 2);
        for(int i : result) {
            System.out.println(i);
        }
    }
}
