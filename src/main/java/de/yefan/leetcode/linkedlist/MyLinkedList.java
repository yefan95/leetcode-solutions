package de.yefan.leetcode.linkedlist;

/**
 * Single List Operation
 */
public class MyLinkedList {

    private ListNode head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;

        for (int i = 0; i < index && curr.next != null; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {

        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;

        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            ListNode newTail = new ListNode(val);
            head = newTail;
            size++;
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;

        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode curr = head;
        ListNode newNode = new ListNode(val);
        while (index > 1) {
            curr = curr.next;
            index--;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (size == 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode node = head;

        while (index > 1) {
            node = node.next;
            index--;
        }
        node.next = node.next.next;
        size--;
    }

    /**
     * Traverse ListNode
     */
    public void traverse() {
        if (head == null) {
            return;
        }
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1, 2);
        linkedList.traverse();
//        linkedList.addAtTail(3);
//        linkedList.traverse();
        // linked list becomes 1->2->3

//        linkedList.traverse();
        // returns 2
        int res1 = linkedList.get(1);
        System.out.println(res1);
        // now the linked list is 1->3
//        linkedList.deleteAtIndex(1);
//        linkedList.traverse();
        // returns 3
        int res2 = linkedList.get(0);
        System.out.println(res2);

        int res3 = linkedList.get(2);
        System.out.println(res3);
    }
}

/**
 * Define ListNode.
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
