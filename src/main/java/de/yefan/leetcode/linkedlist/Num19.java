package de.yefan.leetcode.linkedlist;

/**
 * Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class Num19 {


    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == n) {
            head = head.next;
            return head;
        }

        cur = head;
        int k = len - n;

        while (k > 1) {
            cur = cur.next;
            k--;
        }

        cur.next = cur.next.next;

        return head;
    }


}
