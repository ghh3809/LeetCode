package merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val > node2.val) {
                    return 1;
                } else if (node1.val < node2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        ListNode root = new ListNode(0);
        ListNode node = root;
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            node.next = n;
            node = node.next;
            if (n.next != null) {
                pq.add(n.next);
            }
        }
        return root.next;
    }
}
