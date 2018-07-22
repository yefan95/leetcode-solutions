package de.yefan.leetcode.linkedlist;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Reorder List
 * https://leetcode.com/problems/reorder-list/description/
 */
public class Num143 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            map.put(index, cur);
            cur = cur.next;
            index++;
        }
        cur = head;
        int start = 0;
        int n = map.size() - 1;
        while (start <= map.size() / 2) {
            if (start == 0) {
                cur.next = map.get(n - start);
                cur = map.get(n - start);
                cur.next = null;
            } else {
                cur.next = map.get(start);
                cur.next.next = map.get(n - start);
                cur = map.get(n - start);
                cur.next = null;
            }
            start++;
        }
        if (n % 2 == 1) {
            cur.next = map.get(n / 2 + 1);
            cur.next.next = null;
        }
    }


    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head, fast = head.next;

        // Find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tep2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tep2;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public void reorderList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode headCurr = head;

        int size = stack.size();
        while (stack.size() > Math.ceil((double) size / 2)) {
            ListNode next = stack.pop();
            ListNode nextNext = headCurr.next;
            next.next = null;
            headCurr.next = next;
            next.next = nextNext;
            headCurr = nextNext;
        }

        if (headCurr != null) {
            headCurr.next = null;
        }
    }

}
