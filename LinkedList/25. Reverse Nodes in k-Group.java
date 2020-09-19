/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
    
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode p1=head;
        ListNode p2=p1;

        for(int i=0;i<k;i++){
            if(p2==null) return head;
            p2=p2.next;
        }

        //先对 p1 p2之间的链表进行反转
        ListNode newHead = reverse(p1,p2);

        //反转之后，此时p1是newHead的最后一个节点了，所以
        // 通过p1.next指向后面反转的链表 
        p1.next=reverseKGroup(p2,k);

        return newHead;

    }

    //反转 head tail之间的链表节点
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre,cur,nxt;
        pre=null;
        cur=nxt=head;

        while(cur != tail){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }

        return pre;
    }

}