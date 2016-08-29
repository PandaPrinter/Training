public class LRUCache {
    
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;
    
    public class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        else {
            return -1;
        }
    }
    
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        }
        else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        }
        else {
            tail = n.pre;
        }
    }
    
    public void setHead(Node n) {
        n.pre = null;
        n.next = head;
        if (head != null) head.pre = n;
        head = n;
        if (tail == null) tail = head;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node originalNode = map.get(key);
            originalNode.val = value;
            remove(originalNode);
            setHead(originalNode);
        }
        else {
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            setHead(newNode);
        }
    }
}
