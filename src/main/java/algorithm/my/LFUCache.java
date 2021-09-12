package algorithm.my;

import java.util.HashMap;

/**
 * 460. LFU 缓存
 * @author: xiongyayun
 * @date: 2021/9/5 13:50
 */
class LFUCache {
    HashMap<Integer, CacheNode> cache;
    CacheNode head;
    CacheNode tail;
    int capacity;
    int size;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        moveToNewPosition(node);
        return node.value;
    }

    private void moveToNewPosition(CacheNode node) {
        CacheNode nextNode = node.next;
        removeNode(node);
        while (nextNode.freq <= node.freq && nextNode != tail) {
            nextNode = nextNode.next;
        }
        nextNode.pre.next = node;
        node.pre = nextNode.pre;
        node.next = nextNode;
        nextNode.pre = node;

    }

    private void removeNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        CacheNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.freq++;
            moveToNewPosition(node);
        } else {
            if (size == capacity) {
                cache.remove(head.next.key);
                removeNode(head.next);
                size--;
            }
            CacheNode newNode = new CacheNode(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            size++;
        }
    }

    private void addNode(CacheNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        moveToNewPosition(node);
    }

    public static class CacheNode {
        public int key;
        public int value;
        public int freq = 1;
        public CacheNode pre;
        public CacheNode next;

        public CacheNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}