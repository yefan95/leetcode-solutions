package de.yefan.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class Num234 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode curr = head;

        List<Integer> list = new ArrayList<>();

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        int index = list.size() - 1;
        while (curr != null) {
            if (curr.val != list.get(index)) {
                return false;
            }
            curr = curr.next;
            index--;
        }

        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.val == head.next.val && head.next.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {
            if (slow.val == fast.next.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || slow.val == fast.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }

        return false;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // detect the length
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }
        // reverse the first half list
        ListNode p = head, q = null, r = p.next;
        for (int i = 0; i < len / 2; i++) {
            p.next = q;
            q = p;
            p = r;
            r = r.next;
        }
        // detect the palindrome from the mid
        r = len % 2 == 0 ? p : r;
        while (r != null && q != null) {
            if (r.val != q.val) {
                return false;
            }
            r = r.next;
            q = q.next;
        }
        return r == null && q == null;
    }

}
