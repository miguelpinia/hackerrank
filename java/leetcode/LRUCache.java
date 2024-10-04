
import java.util.HashMap;
import java.util.Map;

/*
 * Copyright (c) 2024 miguel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    miguel - initial API and implementation and/or initial documentation
 */
/**
 * 146. LRU Cache Solved Medium
 *
 * Topics Hash Table Linked List Design Doubly-Linked List
 *
 * Companies Design a data structure that follows the constraints of a Least
 * Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1. void put(int key, int value) Update the value of the key if the
 * key exists. Otherwise, add the key-value pair to the cache. If the number of
 * keys exceeds the capacity from this operation, evict the least recently used
 * key. The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get",
 * "get"] [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]] Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation LRUCache lRUCache = new LRUCache(2); lRUCache.put(1, 1); // cache
 * is {1=1} lRUCache.put(2, 2); // cache is {1=1, 2=2} lRUCache.get(1); //
 * return 1 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1,
 * 3=3} lRUCache.get(2); // returns -1 (not found) lRUCache.put(4, 4); // LRU
 * key was 1, evicts key 1, cache is {4=4, 3=3} lRUCache.get(1); // return -1
 * (not found) lRUCache.get(3); // return 3 lRUCache.get(4); // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000 0 <= key <= 104 0 <= value <= 105 At most 2 * 105 calls
 * will be made to get and put.
 *
 *
 * @author miguel
 */
public class LRUCache {

    Map<Integer, Node> values = new HashMap<>();
    DLList dll = new DLList();
    int capacity = 0;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        Node lruNode = values.get(key);
        if (lruNode != dll.head) {
            dll.remove(lruNode);
            dll.addFirst(lruNode);
        }
        return lruNode.value;
    }

    private void evictLRU() {
        Node lru = dll.tail;
        if (lru == null) {
            return;
        }
        dll.remove(lru);
        values.remove(lru.key);
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            dll.remove(values.get(key));
        } else if (values.size() >= capacity) {
            evictLRU();
        }
        Node nn = new Node(key, value);
        dll.addFirst(nn);
        values.put(key, nn);
    }

    class Node {

        int value;
        int key;
        Node next;
        Node prev;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }

    }

    class DLList {

        Node head = null;
        Node tail = null;

        void addFirst(Node n) {
            if (head != null) {
                n.next = head;
                head.prev = n;
            }
            if (tail == null) {
                tail = n;
            }
            head = n;
        }

        void remove(Node n) {
            if (n == null) {
                return;
            }
            Node prev = n.prev;
            Node next = n.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            if (head == n) {
                head = next;
            }
            if (tail == n) {
                tail = prev;
            }
            n.prev = null;
            n.next = null;
        }
    }

}
