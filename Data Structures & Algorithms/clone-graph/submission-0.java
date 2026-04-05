/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {
  public Node cloneGraph(Node node) {
    if(node == null) return null;
    Map<Integer, Node> nodeMap = new HashMap<>();

    Queue<Node> que = new LinkedList<>();
    
    que.offer(node);
    nodeMap.put(node.val, new Node(node.val));

    while(!que.isEmpty()){
      Node curNode = que.poll();
      List<Node> neighbors = curNode.neighbors;

      for(Node n: neighbors){

        if(nodeMap.containsKey(n.val)) {
            nodeMap.get(n.val).neighbors.add(nodeMap.get(curNode.val));
            continue;
        }
        nodeMap.put(n.val, new Node(n.val));
        nodeMap.get(n.val).neighbors.add(nodeMap.get(curNode.val));
        que.offer(n);
      }
    }

    return nodeMap.get(1);
  }
}