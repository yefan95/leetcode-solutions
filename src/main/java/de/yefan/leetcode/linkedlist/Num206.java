package de.yefan.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class Num206 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;

        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        int index = list.size() - 1;
        while (cur != null) {
            cur.val = list.get(index);
            cur = cur.next;
            index--;
        }

        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

}
