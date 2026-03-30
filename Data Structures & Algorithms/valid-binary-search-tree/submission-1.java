/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Solution {
         public boolean isValidBST(TreeNode root) {
                  return isValid(root, -1001, 1001);
                       }
                        
                             boolean isValid(TreeNode cur, int left, int right) {
                                      if (cur == null) return true;
                                       
                                                if (cur.val <= left || cur.val >= right) return false;
                                                 
                                                          return isValid(cur.left, left, cur.val) && isValid(cur.right, cur.val, right);
                                                               }
                                                                }

 
