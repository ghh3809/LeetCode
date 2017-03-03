package add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = l1.val;
        int v2 = l2.val;
        boolean flag = false;
        l1 = l1.next;
        l2 = l2.next;
        ListNode result, currentNode, nextNode;
        if (v1 + v2 < 10) {
            result = new ListNode(v1 + v2);
        } else {
            result = new ListNode(v1 + v2 - 10);
            flag = true;
        }
        currentNode = result;
        while ((l1 != null) || (l2 != null)) {
            if (l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.val;
            }
            if (l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.val;
            }
            int v3 = flag ? 1 : 0;
            if (v1 + v2 + v3 < 10) {
                nextNode = new ListNode(v1 + v2 + v3);
                flag = false;
            } else {
                nextNode = new ListNode(v1 + v2 + v3 - 10);
                flag = true;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flag) {
            currentNode.next = new ListNode(1);
        }
        return result;
    }
}
