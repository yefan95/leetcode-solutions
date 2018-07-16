package de.yefan.leetcode.linkedlist;

/**
 * Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class Num25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // find the k+1 node
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        // if k+1 node is found
        if (count == k) {
            // reverse list with k+1 node as head
            curr = reverseKGroup(curr, k);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;

            // reverse current k-group:
            while (count-- > 0) {
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = curr;
                // move head of reversed part to a new node
                curr = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev, start, then, tail;
        tail = prev = newHead;
        start = prev.next;
        while (true) {
            // check if there's k nodes left-out
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return newHead.next;
                }
            }
            // reverse k nodes
            for (int i = 0; i < k - 1; i++) {
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            tail = prev = start;
            start = prev.next;
        }
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        //s: start, e: end
        ListNode s = dmy, e = dmy.next;
        for (int i = n; i >= k; i -= k) {
            // reverse group
            for (int j = 1; j < k; j++) {
                ListNode next = e.next;
                e.next = next.next;
                next.next = s.next;
                s.next = next;
            }
            s = e;
            e = s.next;
        }
        return dmy.next;
    }


}
