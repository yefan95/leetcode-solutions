package de.yefan.leetcode.linkedlist;


/**
 * Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */

public class Num160 {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null || curB != null) {
            if (curA != null) {
                curA = curA.next;
            } else {
                headB = headB.next;
            }
            if (curB != null) {
                curB = curB.next;
            } else {
                headA = headA.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int aLen = 0, bLen = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            aLen++;
            curA = curA.next;
        }

        while (curB != null) {
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if (aLen > bLen) {
            for (int i = aLen - bLen; i > 0; i--) {
                curA = curA.next;
            }
        } else {
            for (int i = bLen - aLen; i > 0; i--) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }
}


