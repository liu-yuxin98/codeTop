import java.util.HashMap;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(Node pre, Node next, int key, int val) {
            this.pre = pre;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }

    Node sentinel;
    HashMap<Integer, Node> map;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        Node sentinel = new Node(null, null, -1, -1);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        this.sentinel = sentinel;
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            appendNode(node);
            return node.val;
        }
        return -1;
    }

    public void removeNode(Node node) {
        // remove node from sentinel
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }

    public void appendNode(Node node) {
        // append node to the last
        Node last = sentinel.pre;
        last.next = node;
        node.pre = last;
        sentinel.pre = node;
        node.next = sentinel;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update node
            Node node = map.get(key);
            removeNode(node);
            appendNode(node);
            node.val = value;
            map.put(key, node);
        } else {
            // add node
            Node node = new Node(null, null, key, value);
            appendNode(node);
            map.put(key, node);
            this.size += 1;
        }

        if (this.size > this.capacity) {
            // remove LRU node
            Node LRUnode = sentinel.next;
            removeNode(LRUnode);
            map.remove(LRUnode.key);
            this.size -= 1;

        }

    }
}
