package de.yefan.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 **/
public class Num23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(list);

        ListNode head = null;
        ListNode prev = null;

        for (int i = 0; i < list.size(); i++) {
            if (head == null) {
                head = new ListNode(list.get(i));
                prev = head;
            } else {
                ListNode newNode = new ListNode(list.get(i));
                prev.next = newNode;
                prev = newNode;
            }
        }

        return head;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        return mergeK(lists, 0, lists.length - 1);
    }

    public ListNode mergeK(ListNode[] list, int start, int end) {
        if (start == end) {
            return list[start];
        }
        if (start < end) {
            int mid = (end + start) / 2;
            ListNode a = mergeK(list, start, mid);
            ListNode b = mergeK(list, mid + 1, end);
            return merge(a, b);
        } else {
            return null;
        }
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;

        if (lists == null || len == 0) {
            return null;
        }

        if (len == 1) {
            return lists[0];
        }

        while (len > 1) {
            int mid = (len + 1) / 2;
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i + mid]);
            }
            len = mid;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }

        ListNode head = new ListNode(0);
        ListNode phead = head;

        while (L1 != null && L2 != null) {
            if (L1.val <= L2.val) {
                phead.next = L1;
                phead = phead.next;
                L1 = L1.next;
            } else {
                phead.next = L2;
                phead = phead.next;
                L2 = L2.next;
            }
        }
        if (L1 != null) {
            phead.next = L1;
        } else {
            phead.next = L2;
        }
        return head.next;
    }

}
