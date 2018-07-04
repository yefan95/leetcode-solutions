package de.yefan.leetcode.linkedlist;

/**
 * Flatten a Multilevel Doubly Linked List
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
 */
public class FlattenDoubleLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {
                Node nextTemp = cur.next;

                cur.next = flatten(cur.child);
                cur.child = null;
                cur.next.prev = cur;

                if (nextTemp != null) {
                    Node p = cur.next;
                    while (p.next != null) {
                        p = p.next;
                    }
                    p.next = nextTemp;
                    nextTemp.prev = p;
                }

                cur = nextTemp;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


}
