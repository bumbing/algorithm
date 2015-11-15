package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by maliu2 on 11/12/15.
 */
public class MergeKSortedLists {
    MergeKSortedLists(){}

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)  return null;
        PriorityQueue<ListNode> nodes = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(ListNode node : lists){
            if(node != null)    nodes.add(node);
        }
        while(nodes.size() != 0){
            ListNode temp = nodes.poll();
            if(temp.next != null)   nodes.add(temp.next);
            head.next = temp;
            head = temp;
        }

        return dummy.next;
    }
}
