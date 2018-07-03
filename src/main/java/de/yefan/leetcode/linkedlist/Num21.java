package de.yefan.leetcode.linkedlist;

/**
 * Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Num21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode root = null;
        ListNode pre = null;

        while (head1 != null && head2 != null) {
            int val = Math.min(head1.val, head2.val);
            if (root == null) {
                root = new ListNode(val);
                pre = root;
            } else {
                ListNode node = new ListNode(val);
                pre.next = node;
                pre = node;
            }
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            ListNode node = new ListNode(head1.val);
            head1 = head1.next;
            pre.next = node;
            pre = node;
        }

        while (head2 != null) {
            ListNode node = new ListNode(head2.val);
            head2 = head2.next;
            pre.next = node;
            pre = node;
        }

        return root;
    }

}
