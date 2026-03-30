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
       public ListNode reverseKGroup(ListNode head, int k) {
        
                 ListNode dummy = new ListNode(0);
                          dummy.next = head;
                                   ListNode slow = dummy;
                                            ListNode fast = dummy;
                                             
                                                      
                                                               while (true) {
                                                                int cnt =k;
                                                                            while (fast != null && cnt > 0) {
                                                                                             fast = fast.next;
                                                                                                              cnt--;
                                                                                                                           }
                                                                                                                                        if (fast == null) break;
                                                                                                                                         
                                                                                                                                                      ListNode start = slow.next;
                                                                                                                                                                   ListNode nextGroup = fast.next;
                                                                                                                                                                                fast.next = null;
                                                                                                                                                                                 
                                                                                                                                                                                              slow.next = reverse(start);
                                                                                                                                                                                                           start.next = nextGroup;
                                                                                                                                                                                                                        slow = start;
                                                                                                                                                                                                                                     fast = slow;
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                        return dummy.next;
                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                                   ListNode reverse(ListNode head) {
                                                                                                                                                                                                                                                                            ListNode cur = head;
                                                                                                                                                                                                                                                                                     ListNode prev = null;
                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                               while (cur != null) {
                                                                                                                                                                                                                                                                                                            ListNode next = cur.next;
                                                                                                                                                                                                                                                                                                                         cur.next = prev;
                                                                                                                                                                                                                                                                                                                                      prev = cur;
                                                                                                                                                                                                                                                                                                                                                   cur = next;
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                     return prev;
                                                                                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                                                                           }

