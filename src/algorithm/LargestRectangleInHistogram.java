package algorithm;

import java.util.Stack;

/**
 * Created by maliu2 on 11/14/15.
 */
public class LargestRectangleInHistogram {
    public LargestRectangleInHistogram(){}

    public int largestRectangleArea(int[] height) {
        if(height.length == 0)  return 0;
        Stack high = new Stack();
        int result = 0;
        for(int i = 0; i < height.length; i++){
            result = Math.max(result, addLast(high, height, i));
        }
        result = Math.max(result, addLast(high, height, height.length));
        return result;
    }

    public int addLast(Stack high, int[] height, int insert){
        int result = 0;
        int index = (insert == height.length) ? 0 : height[insert];
        if(high.empty())    high.push(insert);
        else{
            while(height[(int)high.peek()] > index){
                int temp = (int)high.pop();
                result = Math.max(result, (insert - (high.empty()?0:(int)high.peek() + 1))*height[temp]);
                if(high.empty())    break;
            }
            high.push(insert);
        }
        return result;
    }
    //害怕stack为空和peek不能同时为条件，其实这个function call只是一行代码

    public static void main(String[] args){
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[] {1}));
    }
}
