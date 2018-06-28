package de.yefan.leetcode;

/**
 * Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */


public class Num2 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode p = null;

        while ((l1 != null && l1.val >= 0) || (l2 != null && l2.val >= 0)) {
            if (result == null) {
                result = new ListNode(l1.val + l2.val);
                p = result;
            } else {
                ListNode tmp = null;
                if (l1 == null) {

                    p.next = l2;
                    break;
                } else if (l2 == null) {

                    p.next = l1;
                    break;
                } else {
                    tmp = new ListNode(l2.val + l1.val);
                    p.next = tmp;
                    p = tmp;
                }

            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode p1 = result;

        while (p1 != null && p1.val >= 0) {

            int num = p1.val / 10;
            int data = p1.val % 10;


            if (p1.next == null) {
                if (num > 0) {
                    p1.val = data;
                    ListNode tmp = new ListNode(num);
                    p1.next = tmp;
                }
            } else {
                p1.val = data;
                p1.next.val = p1.next.val + num;
            }

            p1 = p1.next;
        }
        return result;
    }


}
