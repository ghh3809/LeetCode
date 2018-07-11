package remove_duplicates_from_sorted_list_ii;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(head.val - 1);
        newHead.next = head;
        ListNode first = newHead, index = head.next;
        boolean equalFlag = false;
        while (index != null) {
            if (index.val == first.next.val) {
                equalFlag = true;
            } else {
                if (equalFlag) first.next = index;
                else first = first.next;
                equalFlag = false;
            }
            index = index.next;
        }
        if (equalFlag) first.next = index;
        return newHead.next;
    }
}
