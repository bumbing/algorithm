package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by maliu2 on 11/10/15.
 */
public class Skyline {
    public Skyline(){}

    public List<int[]> getSkyline(int[][] buildings){
        ArrayList<int[]> points = new ArrayList<int[]>();
        int index = 0;
        List<int[]> result = new ArrayList<int[]>();

        while(!points.isEmpty() || index < buildings.length){
            if(points.isEmpty()){
                result.add(new int[] {buildings[index][0], buildings[index][2]});
                points.add(0, new int[] {buildings[index][1], buildings[index][2]} );
            } else if(points.get(0)[0] < buildings[index][0]){
                int temp = (points.get(0))[0];
                points.remove(0);
                result.add(new int[] {temp, (points.get(0))[1]});
            } else {
                if(buildings[index][2] > (points.get(0))[1])    result.add(new int[] {buildings[index][0], buildings[index][2]});
                insert(buildings[index], points);
            }

        }
        return result;

    }

    public void insert(int[] building, ArrayList<int[]> points){
        for(int i = points.size() - 1; i >=0; i--){
            int temp = points.get(i)[0];
            if(temp > building[1] ){
                continue;
            }else if(temp < building[0]){
                break;
            }else{
                if(points.get(i)[1] > building[2])  break;
                else{
                    points.remove(i);
                }
            }
        }

    }


}
