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

public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder str = new StringBuilder();
    helper(root, str);
    return str.toString();
  }

  void helper(TreeNode root, StringBuilder builder) {
    if (root == null) {
      builder.append("#").append(",");
      return;
    }
    builder.append(root.val).append(",");
    helper(root.left, builder);
    helper(root.right, builder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return helper(queue);
  }

  TreeNode helper(Queue<String> queue) {
    String token = queue.poll();
    if (token.equals("#")) return null;
    TreeNode node = new TreeNode(Integer.parseInt(token));
    node.left = helper(queue);
    node.right = helper(queue);
    return node;
  }
}