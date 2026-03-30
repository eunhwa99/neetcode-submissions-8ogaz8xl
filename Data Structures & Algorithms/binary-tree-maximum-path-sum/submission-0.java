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
         int maxVal = Integer.MIN_VALUE;
          
               public int maxPathSum(TreeNode root) {
                        helper(root);
                                 return maxVal; // 최종적으로 전역 변수에 저장된 최댓값 반환
                                      }
                                       
                                            private int helper(TreeNode node) {
                                                     if (node == null) return 0;
                                                      
                                                               int left = Math.max(0, helper(node.left));
                                                                        int right = Math.max(0, helper(node.right));
                                                                         
                                                                                  // [중요!] 현재 노드를 정점으로 '왼쪽-현재-오른쪽'을 다 잇는 경로를 최댓값 후보로 체크
                                                                                           maxVal = Math.max(maxVal, node.val + left + right);
                                                                                            
                                                                                                     // 부모 노드에게는 한 방향(왼쪽 또는 오른쪽 중 큰 것)만 선택해서 전달
                                                                                                              return node.val + Math.max(left, right);
                                                                                                                   }
                                                                                                                    }

