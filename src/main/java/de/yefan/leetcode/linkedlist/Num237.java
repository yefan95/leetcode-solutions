package de.yefan.leetcode.linkedlist;

/**
 * Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class Num237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
