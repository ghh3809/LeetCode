package partition_list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode left = newHead, index = newHead;
        while ((index.next != null) && (index.next.val < x)) { left = left.next; index = index.next; }
        while ((index.next != null) && (index.next.val >= x)) index = index.next;
        while (index.next != null) {
            if (index.next.val >= x) {
                index = index.next;
            } else {
                ListNode node = index.next;
                index.next = node.next;
                node.next = left.next;
                left.next = node;
                left = left.next;
            }
        }
        return newHead.next;
    }
}
