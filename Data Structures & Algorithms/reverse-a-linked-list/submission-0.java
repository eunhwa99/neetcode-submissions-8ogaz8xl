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
         public ListNode reverseList(ListNode head) {
                  if (head == null) return null;
                           ListNode cur = head;
                                    ListNode next = cur.next;
                                             cur.next = null;
                                                      while (next != null) {
                                                                   ListNode tmp = next.next;
                                                                                next.next = cur;
                                                                                 
                                                                                              cur = next;
                                                                                                           next = tmp;
                                                                                                                    }
                                                                                                                             return cur;
                                                                                                                                  }
                                                                                                                                   }

 
