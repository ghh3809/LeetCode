package merge_two_sorted_lists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode lastNode = result;
        while ((l1 != null) || (l2 != null)) {
            if (l1 == null) {
                lastNode.next = l2;
                break;
            } else if (l2 == null) {
                lastNode.next = l1;
                break;
            } else if (l1.val > l2.val) {
                lastNode.next = new ListNode(l2.val);
                lastNode = lastNode.next;
                l2 = l2.next;
            } else {
                lastNode.next = new ListNode(l1.val);
                lastNode = lastNode.next;
                l1 = l1.next;
            }
        }
        return result.next;
    }
}
