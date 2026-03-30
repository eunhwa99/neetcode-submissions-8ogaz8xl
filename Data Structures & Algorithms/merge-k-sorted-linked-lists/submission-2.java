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
  public ListNode mergeKLists(ListNode[] lists) {

    int len = lists.length;
    if(len==0) return null;
    int interval = 1;
    while(interval < len){
      for(int i=0;i+interval<len;i+=interval*2){
        lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
      }
      interval *=2;
    }
    return lists[0];

  }

  ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode dummy = new ListNode(0);
    ListNode res = dummy;
    while(l1!=null && l2!=null){
      if(l1.val < l2.val){
        dummy.next = l1;
        l1 = l1.next;
      }
      else{
        dummy.next=l2;
        l2=l2.next;
      }
      dummy = dummy.next;
    }
    if(l1!=null) dummy.next = l1;
    else dummy.next = l2;

    return res.next;
  }
}
