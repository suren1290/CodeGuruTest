package org.blacksun.pediredla;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pediredla on 1/14/17.
 */
public class LRUCacheTrad {
    private int capacity;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public LRUCacheTrad(int cap) {
        this.capacity = cap;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            Node old = cache.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if(cache.size()>=capacity) {
                cache.remove(tail.key);
                remove(tail);
                setHead(created);
            } else {
                setHead(created);
            }
            cache.put(key, created);
        }
    }

    private void remove(Node key) {
        if(key.pre == null) {
            key.pre.next = key.next;
        } else {
            head = key.next;
        }
        if(key.next == null) {
            key.next.pre = key.pre;
        } else {
            tail = key.pre;
        }
    }

    private void setHead(Node key) {
        key.next = head;
        key.pre = null;
        if(head != null) {
            head.pre = key;
        }
        head = key;
        if(tail == null) {
            tail = head;
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
