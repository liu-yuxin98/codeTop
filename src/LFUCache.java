import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        int key;
        int val;
        int freq;
        int len; // length of this Node

        Node pre;
        Node next;
        Node up;
        Node down;

        public Node(Node pre, Node next, Node up, Node down, int key, int val, int freq, int len) {
            this.pre = pre;
            this.next = next;
            this.up = up;
            this.down = down;
            this.key = key;
            this.val = val;
            this.freq = freq;
            this.len = len;
        }

    }

    Map<Integer, Node> valueMap;
    Map<Integer, Node> freqMap;
    int size;
    int capacity;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
        Node freqSentinel = new Node(null, null, null, null, 0, 0, 0, 0);
        freqSentinel.up = freqSentinel;
        freqSentinel.down = freqSentinel;
        freqMap.put(0, freqSentinel);
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            Node node = valueMap.get(key);
            // freq+1 for this node
            freqAddOne(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (valueMap.containsKey(key)) {
            // update existing node
            Node node = valueMap.get(key);
            // freq+1
            freqAddOne(node);
            // add to map
            node.val = value;
            valueMap.put(key, node);
        } else {
            if (this.size >= this.capacity) {
                // remove LRU first
                removeLRU();
            }
            addNewNode(key, value);

        }

    }


    public void removeLRU() {
        Node freqSentinel = freqMap.get(0).down;
        Node removed = freqSentinel.next;
        valueMap.remove(removed.key);
        removeValNode(removed);
        freqSentinel.len -= 1;
        if (freqSentinel.len == 0) {
            removeFreqNode(freqSentinel);
            freqMap.remove(freqSentinel.freq);
        }
        this.size -= 1;
    }

    public void addNewNode(int key, int value) {
        Node node = new Node(null, null, null, null, key, value, 1, 0);
        if (!freqMap.containsKey(1)) {
            // no freq1 we need to add
            Node sentinelZero = freqMap.get(0);
            insertFreqNode(sentinelZero, 1);
        }
        Node sentinelOne = freqMap.get(1);
        appendValNode(sentinelOne, node);
        valueMap.put(key, node);
        this.size += 1;
    }

    public void freqAddOne(Node node) {
        // remove node from olfFreqSentinel
        removeValNode(node);

        Node olfFreqSentinel = freqMap.get(node.freq);
        node.freq += 1;

        // append node to newFreqSentinel
        if (!freqMap.containsKey(node.freq)) {
            // need to insert a node to freqMap and the FreNode list
            insertFreqNode(olfFreqSentinel, node.freq);
        }
        // append node to end of this newFreqSentinelNode
        Node newFreqSentinel = freqMap.get(node.freq);
        appendValNode(newFreqSentinel, node);

        // update freqMap if need to remove olfFreqSentinel
        olfFreqSentinel.len -= 1;
        if (olfFreqSentinel.len == 0 && olfFreqSentinel!= freqMap.get(0)) {
            removeFreqNode(olfFreqSentinel);
            // remove this freq from freqMap
            freqMap.remove(olfFreqSentinel.freq);
        }

    }

    public void insertFreqNode(Node freqNode, int freq) {
        //insert a freqNode after freqNode
        Node down = freqNode.down;
        Node insertFreqNode = new Node(null, null, null, null, 0, 0, freq, 0);
        freqNode.down = insertFreqNode;
        insertFreqNode.up = freqNode;
        down.up = insertFreqNode;
        insertFreqNode.down = down;
        insertFreqNode.next = insertFreqNode;
        insertFreqNode.pre = insertFreqNode;
        // put it into freqMap
        freqMap.put(freq, insertFreqNode);
    }

    public void removeFreqNode(Node freqNode) {
        Node up = freqNode.up;
        Node down = freqNode.down;
        up.down = down;
        down.up = up;
        freqNode.down = null;
        freqNode.up = null;
    }

    public void appendValNode(Node sentinelNode, Node node) {
        sentinelNode.len += 1;
        Node last = sentinelNode.pre;
        last.next = node;
        node.pre = last;
        sentinelNode.pre = node;
        node.next = sentinelNode;
    }

    public void removeValNode(Node valNode) {
        Node pre = valNode.pre;
        Node next = valNode.next;
        pre.next = next;
        next.pre = pre;
        valNode.next = null;
        valNode.pre = null;
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        System.out.println(lfuCache.get(4));

    }

}
