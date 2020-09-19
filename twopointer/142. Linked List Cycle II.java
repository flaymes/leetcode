/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow,fast;
        fast=head;
        slow=head;
        // boolean cycleFlag=false;
        //判断是否有环
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                // cycleFlag=true;
                break;
            }
        }

        // if(!cycleFlag){
            // return null;
        // }
        //无环
        if(fast==null||fast.next==null){
            return null;
        }

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}