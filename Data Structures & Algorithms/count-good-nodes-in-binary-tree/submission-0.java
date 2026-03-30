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
class Node {
        TreeNode cur;
            int maxValue;

                Node(TreeNode cur, int maxValue) {
                        this.cur = cur;
                                this.maxValue = maxValue;
                                    }
                                    }

                                    class Solution {
                                        public int goodNodes(TreeNode root) {

                                                if (root == null) return 0;
                                                        int res = 0;

                                                                Queue<Node> queue = new LinkedList<>();
                                                                        queue.add(new Node(root, -101));
                                                                                while (!queue.isEmpty()) {
                                                                                            int size = queue.size();
                                                                                                        for (int i = 0; i < size; i++) {
                                                                                                                        Node curNode = queue.poll();
                                                                                                                                        TreeNode curTree = curNode.cur;
                                                                                                                                                        int previousMax = curNode.maxValue;
                                                                                                                                                                        if (curTree.val >= previousMax) {
                                                                                                                                                                                            previousMax = curTree.val;
                                                                                                                                                                                                                res += 1;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                if (curTree.left != null) queue.add(new Node(curTree.left, previousMax));
                                                                                                                                                                                                                                                                if (curTree.right != null) queue.add(new Node(curTree.right, previousMax));
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                            return res;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                }

