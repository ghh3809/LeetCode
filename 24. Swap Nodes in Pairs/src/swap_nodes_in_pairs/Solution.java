package swap_nodes_in_pairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root, last = null;
        if ((head != null) && (head.next != null)) {
            root = head.next;
        } else {
            return head;
        }
        while ((head != null) && (head.next != null)) {
            ListNode first = head;
            ListNode second = head.next;
            if (last != null) {
                last.next = second;
            }
            first.next = second.next;
            second.next = first;
            head = first.next;
            last = first;
        }
        return root;
    }
}
