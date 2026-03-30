 
class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.val=value;
    }
}
    class LRUCache {
        int capacity; // 남아있는 용량이 아니라 '전체 용량'으로 쓰는 게 관리하기 편합니다.
        Map<Integer, Node> map;
        Node head, tail;
 
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
 
        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node cur = map.get(key);
 
            // 1. 현재 위치에서 제거
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
 
            // 2. tail 앞으로 이동 (여기가 수정됨!)
            cur.prev = tail.prev;
            cur.next = tail;      // 👈 tail.next가 아니라 tail 자신!
            tail.prev.next = cur;
            tail.prev = cur;
 
            return cur.val;
        }
 
        public void put(int key, int value) {
            // 💡 [추가] 이미 있는 키라면 기존 노드를 지우고 시작 (업데이트 로직)
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                oldNode.prev.next = oldNode.next;
                oldNode.next.prev = oldNode.prev;
                map.remove(key);
            } else if (map.size() == capacity) { // 💡 용량 체크는 map.size()로 하는 게 제일 정확해요
                Node firstNode = head.next;
                firstNode.prev.next = firstNode.next;
                firstNode.next.prev = firstNode.prev;
                map.remove(firstNode.key);
            }
 
            Node newNode = new Node(key, value);
            
            // 새 노드를 맨 뒤(tail 앞)에 삽입
            newNode.prev = tail.prev;
            newNode.next = tail;      // 👈 여기도 tail!
            tail.prev.next = newNode;
            tail.prev = newNode;
 
            map.put(key, newNode);
 }
    }