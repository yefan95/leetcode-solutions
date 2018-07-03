package de.yefan.leetcode.linkedlist;

/**
 * Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class Num203 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = fakeHead;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return fakeHead.next;
    }
}
