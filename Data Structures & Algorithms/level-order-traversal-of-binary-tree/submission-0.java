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
        public List<List<Integer>> levelOrder(TreeNode root) {
                if (root == null) return new ArrayList<>();

                        List<List<Integer>> res = new ArrayList<>();
                                Queue<TreeNode> que = new LinkedList<>();
                                        que.add(root);
                                                while (!que.isEmpty()) {
                                                            List<Integer> list = new ArrayList<>();
                                                                        int size = que.size();
                                                                                    for (int i = 0; i < size; i++) {
                                                                                                    TreeNode cur = que.poll();
                                                                                                                    list.add(cur.val);
                                                                                                                                    if (cur.left != null) que.add(cur.left);
                                                                                                                                                    if (cur.right != null) que.add(cur.right);
                                                                                                                                                                }
                                                                                                                                                                            res.add(list);
                                                                                                                                                                                    }

                                                                                                                                                                                            return res;
                                                                                                                                                                                                }
                                                                                                                                                                                                }

