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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                 if (root == null || root.val == p.val || root.val == q.val) {
                                return root;
                                           }

                                                      // 2. 왼쪽과 오른쪽 자식에게서 p와 q를 찾아오라고 시킴 (Post-order 탐색)
                                                                 TreeNode left = lowestCommonAncestor(root.left, p, q);
                                                                            TreeNode right = lowestCommonAncestor(root.right, p, q);

                                                                                       // 3. 결과 판단 로직
                                                                                                  // - 왼쪽에서도 찾았고(not null), 오른쪽에서도 찾았다면(not null)?
                                                                                                             //   내가 바로 p와 q가 갈라지는 "가장 가까운 공통 조상(LCA)"이다!
                                                                                                                        if (left != null && right != null) {
                                                                                                                                       return root;
                                                                                                                                                  }

                                                                                                                                                             // - 한쪽에서만 찾았다면? 찾은 그 결과(노드)를 위로 계속 전달함
                                                                                                                                                                        // - 양쪽 다 null이면 null이 자연스럽게 반환됨
                                                                                                                                                                                   return (left != null) ? left : right;
                                                                                                                                                                                       }
                                                                                                                                                                                       }

