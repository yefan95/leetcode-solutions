package de.yefan.leetcode.linkedlist;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class Num142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode firstp = head;
        ListNode secondp = head;

        boolean isCycle = false;

        while (firstp != null && secondp != null) {
            firstp = firstp.next;
            if (secondp.next == null) {
                return null;
            }
            secondp = secondp.next.next;
            if (firstp == secondp) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }
        firstp = head;
        while (firstp != secondp) {
            firstp = firstp.next;
            secondp = secondp.next;
        }

        return firstp;
    }

}
