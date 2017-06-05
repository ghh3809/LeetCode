package reverse_nodes_in_k_group;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode origin = new ListNode(0);
        origin.next = head;
        ListNode zero, first, last, tail;
        zero = origin;
        while (true) {
            ListNode nextzero = zero.next;
            first = zero.next;
            last = zero;
            for (int i = 0; i < k; i ++) {
                if (last.next == null) {
                    return origin.next;
                } else {
                    last = last.next;
                }
            }
            tail = last.next;
            ListNode temp1 = tail;
            ListNode temp2 = null;
            for (int i = 0; i < k; i ++) {
                temp2 = first.next;
                first.next = temp1;
                temp1 = first;
                first = temp2;
            }
            zero.next = temp1;
            zero = nextzero;
        }
    }
}
