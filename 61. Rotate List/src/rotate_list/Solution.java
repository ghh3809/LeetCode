package rotate_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if ((head == null) || (head.next == null)) return head;
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode != null) {
            lengthNode = lengthNode.next;
            length ++;
        }
        if ((k %= length) == 0) return head;
        
        ListNode back = head, front = head;
        while (k-- > 0) {
            if (front == null) { front = head; }
            front = front.next;
        }
        if (front == null) return head;
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        ListNode newHead = back.next;
        back.next = null;
        front.next = head;
        return newHead;
    }
}
