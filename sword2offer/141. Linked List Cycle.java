package sword2offer;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p = head.next.next;
        ListNode q = head;
        while (p != null && p.next != null) {
            if (p == q) {
                return true;
            }
            p = p.next.next;
            q = q.next;
        }
        return false;
    }
}