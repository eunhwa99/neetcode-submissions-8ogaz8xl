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
    if(lists==null || lists.length==0) return null;
    return dfs(0, lists.length -1, lists);

  }
  
  ListNode dfs(int start, int end, ListNode[] lists){
    if(start==end) return lists[start];
    
    int mid = start + (end-start)/2;
    ListNode l1= dfs(start, mid, lists);
    ListNode l2 = dfs(mid+1, end, lists);
    
    return mergeTwoLists(l1, l2);
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
