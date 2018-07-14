package de.yefan.leetcode.linkedlist;

/**
 * Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class Num82 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode cur = tempHead.next.next;
        ListNode prev = tempHead.next;
        ListNode pre = null;

        while (cur != null) {
            if (prev.val == cur.val) {
                if (cur.next != null && cur.val == cur.next.val) {
                    prev.next = cur.next;
                    cur = cur.next;
                } else {
                    if (pre == null) {
                        tempHead.next = cur.next;
                    } else {
                        pre.next = cur.next;
                    }
                    prev = cur.next;
                    if (prev == null) {
                        break;
                    }
                    cur = prev.next;
                }
            } else {
                pre = prev;
                prev = cur;
                cur = cur.next;
            }
        }

        return tempHead.next;
    }

    public static void main(String[] args) {
        Num82 num82 = new Num82();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        ListNode newNode = num82.deleteDuplicates(head);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }
}
