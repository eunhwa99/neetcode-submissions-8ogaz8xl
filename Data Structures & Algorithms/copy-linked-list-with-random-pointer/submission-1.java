/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while(cur!=null){
            Node copyNode = new Node(cur.val);
            Node next = cur.next;
            cur.next = copyNode;
            copyNode.next = next;
            cur = next;
        }

        cur = head;
        while(cur!=null){
            Node copyNode = cur.next;
            if(cur.random!=null){
                copyNode.random = cur.random.next;
            }
            cur = copyNode.next;
        }

        cur = head;
        Node dummy = new Node(0);
        Node res = dummy;
        while(cur!=null){
            Node copyNode = cur.next;
            cur.next = copyNode.next;
            cur = cur.next;

            dummy.next = copyNode;
        
            dummy = dummy.next;
        }

        return res.next;
    }


}
