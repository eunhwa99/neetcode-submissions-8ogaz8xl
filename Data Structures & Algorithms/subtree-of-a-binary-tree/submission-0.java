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
       public boolean isSubtree(TreeNode root, TreeNode subRoot) {
                if (subRoot == null) return true;
                         if (root == null) return false;
                          
                                   TreeNode cur = root;
                                    
                                             if (isSameTree(cur, subRoot)) return true;
                                                      if(isSubtree(root.left, subRoot)) return true;
                                                               return isSubtree(root.right, subRoot);
                                                                    }
                                                                     
                                                                          boolean isSameTree(TreeNode t1, TreeNode t2) {
                                                                                   if (t1 == null && t2 == null) return true;
                                                                                            if (t1 == null || t2 == null) return false;
                                                                                             
                                                                                                      if (t1.val != t2.val) return false;
                                                                                                               return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
                                                                                                                    }
                                                                                                                     }
                                                                                                                     