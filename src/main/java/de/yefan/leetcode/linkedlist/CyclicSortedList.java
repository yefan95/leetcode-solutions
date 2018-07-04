package de.yefan.leetcode.linkedlist;

/**
 * Insert into a Cyclic Sorted List
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1226/
 */
public class CyclicSortedList {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node pre = head;
        Node next = head.next;

        while (next != null) {
            if (pre.val <= insertVal && next.val >= insertVal //pre.val >= insertVal >= next.val
                    || next.val >= insertVal && pre.val >= next.val
                    // There is no node.val smaller than the insertVal && pre is the tail
                    || pre.val <= insertVal && pre.val >= next.val
                // There is no node.val greater than the insertVal && pre is the tail
                    ) {
                Node node = new Node(insertVal, null);
                pre.next = node;
                node.next = next;
                break;
            }
            pre = next;
            next = next.next;
        }

        return head;
    }


}
