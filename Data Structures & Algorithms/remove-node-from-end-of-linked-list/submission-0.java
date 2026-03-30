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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        
        int len=1;
        ListNode cur=head;
        while(cur.next!=null){
            len++;
            cur=cur.next;
        }
        int index=len-n;
        if(index==0) return head.next;
        cur=head;
while(cur!=null){
            index--;
            if(index==0)
           cur.next=cur.next.next;
            else cur=cur.next;
        }
        return head;
    }
}
