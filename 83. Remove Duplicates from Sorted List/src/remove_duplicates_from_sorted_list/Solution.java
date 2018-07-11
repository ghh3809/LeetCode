package remove_duplicates_from_sorted_list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode first = head, iter = head;
        while (iter != null) {
            if (iter.val != first.val) {
                first.next = iter;
                first = iter;
            }
            iter = iter.next;
        }
        first.next = iter;
        return head;
    }
}
