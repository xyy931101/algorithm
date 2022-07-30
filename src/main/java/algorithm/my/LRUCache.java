package algorithm.my;

import java.util.Comparator;
import java.util.HashMap;

/**
 * @author xiongyayun
 * @date 2021/5/13 22:56
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));;
        lru.put(4, 4);
        System.out.println(lru.get(1));;
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }

    //最大容量
    private int capacity;
    private HashMap<Integer, CacheNode> map;
    private CacheNode head;
    private CacheNode tail;



    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        CacheNode cacheNode = map.get(key);
        //讲最新get的元素移位head节点
        if (cacheNode != null) {
            moveToHead(cacheNode);
            return cacheNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = map.get(key);
        if (cacheNode == null) {
            cacheNode = new CacheNode(key, value);
            if (map.size() >= capacity) {
                removeLast();
            }
        }else {
            cacheNode.value = value;
        }
        map.put(key, cacheNode);
        moveToHead(cacheNode);
    }

    private void removeLast() {
        if (tail != null) {
            map.remove(tail.key);
            tail = tail.pre;
            if (tail == null) {
                head = null;
            }else {
                tail.next = null;
            }
        }
    }


    private void moveToHead(CacheNode cacheNode){
        if (head == cacheNode) {
            return;
        }
        CacheNode pre = cacheNode.pre;
        CacheNode next = cacheNode.next;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }

        if (cacheNode == tail) {
            tail = tail.pre;
        }
        if (head == null || tail == null) {
            tail = cacheNode;
            head = cacheNode;
            return;
        }
        //头节点的pre位当前节点
        head.pre = cacheNode;
        cacheNode.next = head;
        head = cacheNode;
        head.pre = null;
    }

}

class CacheNode {
    CacheNode pre;
    CacheNode next;
    Integer value;
    Integer key;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}