package de.yefan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class Num141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public boolean hasCycle1(ListNode head) {

        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

}
