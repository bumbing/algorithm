package algorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by maliu2 on 11/11/15.
 */
public class MergeInterval {
    public MergeInterval(){}

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for(int index = 0; index < intervals.size()-1; index++){
            Interval temp1 = intervals.get(index);
            Interval temp2 = intervals.get(index+1);
            if( Contain(temp1, temp2) ){
                temp1.start = Math.min(temp1.start, temp2.start);
                temp1.end = Math.max(temp1.end, temp2.end);
                intervals.set(index, temp1);
                intervals.remove(index+1);
                index--;
            }
        }

        return intervals;
    }

    public boolean Contain(Interval a, Interval b){
        return a.end >= b.start;
    }
}
