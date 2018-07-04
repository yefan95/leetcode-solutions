package de.yefan.leetcode.linkedlist;

/**
 * Rotate List
 * https://leetcode.com/problems/rotate-list/description/
 */
public class Num61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            len++;
            prev = cur;
            cur = cur.next;
        }

        if (k >= len) {
            k = k % len;
        }

        if (k == 0) {
            return head;
        }

        int index = len - k - 1;

        cur = head;

        while (index > 0) {
            cur = cur.next;
            index--;
        }

        ListNode newHead;

        newHead = cur.next;
        cur.next = null;

        prev.next = head;

        return newHead;
    }

    public ListNode rotateRight1(ListNode head, int k) {

        ListNode start = head;

        if (k == 0) {
            return start;
        }
        if (head == null) {
            return start;
        }
        int count = 0;


        //traverse till the end of the list and keep incrementing the count
        while (head.next != null) {
            head = head.next;
            count++;
        }
        count++;
        // if k > count, do k%count, its an optimization. 2%5 == 12%5
        k = k % count;
        //find the new k
        k = Math.abs(count - k);
        if (k == 0) {
            return start;
        }
        //connect last element to start
        head.next = start;
        //traverse for new k value
        while (k-- > 0) {
            head = head.next;
        }
        // note: head is not the last element, so set the start.
        start = head.next;
        head.next = null;
        return start;
    }


}


