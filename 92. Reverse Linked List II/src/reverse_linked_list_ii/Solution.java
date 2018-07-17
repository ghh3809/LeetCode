package reverse_linked_list_ii;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode leader = new ListNode(0), outerLeft = leader;
        leader.next = head;
        for (int i = 0; i < m - 1; i ++) {
            outerLeft = outerLeft.next;
        }
        ListNode first = outerLeft.next;
        ListNode second = first.next;
        for (int i = 0; i < n - m; i ++) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        outerLeft.next.next = second;
        outerLeft.next = first;
        return leader.next;
    }
}
