package de.yefan.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 */
public class Num225 {
    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        private int top;


        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
            int sz = queue1.size();
            while (sz > 1) {
                queue1.add(queue1.remove());
                sz--;
            }
        }

        /**
         * Push element x onto stack.
         */
        public void push1(int x) {
            queue1.add(x);
            top = x;
        }

        /**
         * Push element x onto stack.
         */
        public void push2(int x) {
            queue2.add(x);
            top = x;
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue1.remove();
        }

        // Removes the element on top of the stack.
        public void pop1() {
            while (queue1.size() > 1) {
                top = queue1.remove();
                queue2.add(top);
            }
            queue1.remove();
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        // Removes the element on top of the stack.
        public void pop2() {
            queue1.remove();
            if (!queue1.isEmpty()) {
                top = queue1.peek();
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue1.peek();
        }

        /**
         * Get the top element.
         */
        public int top1() {
            return top;
        }


        /**
         * Get the top element.
         */
        public int top2() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty1() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty2() {
            return queue1.isEmpty();
        }
    }


    public static void main(String[] args) {

    }
}
