import java.util.HashMap;
import java.util.Map;

public class LFUCache2 {

    class Node{
        int key;
        int val;
        int freq;
        Node pre;
        Node next;
    }

    Map<Integer,Node> valueMap ;
    Map<Integer,Node> freqMap;
    int size;
    int capacity;
    int minFreq;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 1;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
    }


    public int get(int key) {
        if(valueMap.containsKey(key)){
            Node node = valueMap.get(key);
            addFreqOne(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(valueMap.containsKey(key)){
            Node node = valueMap.get(key);
            node.val = value;
            valueMap.put(key,node);
            addFreqOne(node);
        }else{
            if(this.size>=this.capacity){
                removeLFU();
            }
            addNewNode(key,value);
        }
    }


    public void addNewNode(int key, int val){
        Node node = new Node();
        node.key = key;
        node.val = val;
        node.freq = 1;
        this.minFreq = 1;
        Node sentinelOne = getFreqNode(1);
        appendNode(sentinelOne,node);
    }

    public void removeLFU(){
        Node minFreqSentinel = freqMap.get(minFreq);
        Node removedNode = minFreqSentinel.next;
        removeNode(minFreqSentinel,removedNode);
    }

    public void removeNode(Node freqSentinel, Node node){
        this.size -= 1;
        valueMap.remove(node.key);
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
        if(freqSentinel.next == freqSentinel){
            // need to remove this freq
            freqMap.remove(freqSentinel.freq);
            // check if minFreq need to update
            if(minFreq==freqSentinel.freq){
                minFreq += 1;
            }
        }
    }

    public void appendNode(Node freSentinel, Node node){
        this.size += 1;
        valueMap.put(node.key,node);
        Node last = freSentinel.pre;
        last.next = node;
        node.pre = last;
        freSentinel.pre = node;
        node.next = freSentinel;
    }


    public Node getFreqNode(int freq){
        if(!freqMap.containsKey(freq)){
            Node freqNode = new Node();
            freqNode.next = freqNode;
            freqNode.pre = freqNode;
            freqNode.freq = freq;
            freqMap.put(freq,freqNode);
        }
        return freqMap.get(freq);
    }

    public void addFreqOne(Node node){
        Node oldFreSentinel = freqMap.get(node.freq);
        removeNode(oldFreSentinel, node);
        node.freq+=1;
        Node newFreqSentinel = getFreqNode(node.freq);
        appendNode(newFreqSentinel,node);
    }


}
