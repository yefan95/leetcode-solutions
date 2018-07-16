package de.yefan.leetcode.linkedlist;

/**
 * Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/description/
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Num147 {

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        curr.next = left == null ? right : left;

        return dummy.next;
    }


    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode slowPrev = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPrev.next = null;

        return merge(insertionSortList(head), insertionSortList(slow));
    }

    public ListNode insertionSortList1(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode current = head;
        while (current != null) {
            pre = helper;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return helper.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode end = new ListNode(head.val);
        dummy.next = end;

        ListNode p = head.next;
        while (p != null) {
            ListNode n = new ListNode(p.val);
            if (n.val >= end.val) {
                end.next = n;
                end = n;
            } else {
                insert(dummy, n);
            }
            p = p.next;
        }

        return dummy.next;
    }

    private void insert(ListNode dummy, ListNode newNode) {
        ListNode pre = dummy;
        ListNode now = dummy.next;
        while (now != null) {
            if (now.val >= newNode.val) {
                pre.next = newNode;
                newNode.next = now;
                return;
            }
            now = now.next;
            pre = pre.next;
        }
    }

}
