package de.yefan.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class Num138 {


    /**
     * Definition for singly-linked list with a random pointer.
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode cur = head;

        final Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            final RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }


    public RandomListNode copyRandomList1(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode root = new RandomListNode(head.label);
        RandomListNode newHead = root;

        RandomListNode cur = head;

        while (cur != null) {
            if (cur.random != null) {
                root.random = new RandomListNode(cur.random.label);
            } else {
                root.random = null;
            }
            if (cur.next != null) {
                root.next = new RandomListNode(cur.next.label);
            } else {
                cur.next = null;
            }
            root = root.next;
            cur = cur.next;
        }

        return newHead;
    }

}
