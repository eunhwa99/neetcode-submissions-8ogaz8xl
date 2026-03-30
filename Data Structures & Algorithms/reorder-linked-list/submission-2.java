/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(fast==null) return;
        while(fast!=null&&fast.next!=null){
            slow = slow.next; 
            fast = fast.next.next;}
        
        

        ListNode cur=slow.next;
        ListNode dummy = new ListNode(0);
        ListNode prev=null;
        slow.next=null;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
    
        ListNode front = head;
        ListNode back = prev;
        while(back !=null){
            ListNode tmp1 =front.next;
            ListNode tmp2= back.next;
            front.next = back;
            back.next = tmp1;
            front=tmp1;
            back=tmp2;
        }

    }
}
