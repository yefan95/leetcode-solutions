package de.yefan.leetcode.linkedlist;

import java.util.Stack;

/**
 * Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class Num445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        ListNode cur = l1;
        while (cur != null) {
            stack1.add(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.add(cur.val);
            cur = cur.next;
        }

        int digit = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + digit;
            int val = sum % 10;
            digit = (sum >= 10 ? 1 : 0);
            stack.add(val);
        }

        while (!stack1.isEmpty()) {
            int val = stack1.pop();
            int sum = val + digit;
            val = sum % 10;
            digit = (sum >= 10 ? 1 : 0);
            stack.add(val);
        }

        while (!stack2.isEmpty()) {
            int val = stack2.pop();
            int sum = val + digit;
            val = sum % 10;
            digit = (sum >= 10 ? 1 : 0);
            stack.add(val);
        }

        if (digit > 0) {
            stack.add(digit);
        }

        ListNode head = null;
        ListNode prev = null;

        while (!stack.isEmpty()) {
            ListNode newNode = new ListNode(stack.pop());
            if (head == null) {
                head = newNode;
                prev = head;
            } else {
                prev.next = newNode;
                prev = newNode;
            }
        }

        return head;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        ;
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                sum += s1.pop();
            }
            if (!s2.empty()) {
                sum += s2.pop();
            }
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }


}
