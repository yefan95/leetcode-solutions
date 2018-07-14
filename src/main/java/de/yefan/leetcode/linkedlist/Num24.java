package de.yefan.leetcode.linkedlist;

/**
 * Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class Num24 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;

        ListNode pre = tempHead;
        ListNode prev = tempHead.next;
        ListNode cur = tempHead.next.next;

        while (cur != null) {
            ListNode temp = cur.next;
            pre.next = cur;
            prev.next = temp;
            cur.next = prev;

            if (pre.val == -1) {
                tempHead.next = pre.next;
            }

            pre = prev;

            prev = pre.next;

            if (prev == null) {
                break;
            }

            cur = prev.next;
        }

        return tempHead.next;
    }

    public static void main(String[] args) {
        Num24 num24 = new Num24();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode res = num24.swapPairs(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
