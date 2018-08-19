package de.yefan.leetcode.dynamicprogramming.hanoi;

/**
 * 给定一个整数n，代表汉诺塔游戏从小到大放置的n个圆盘，假设开始时所有的圆盘都放在左边的柱子上，想按汉诺塔游戏的要求
 * 把所有的圆盘都移到右边的柱子上。实现函数打印最优移动轨迹。
 */
public class HannoTower {

    public static void main(String[] args){
        hanoi(3);
    }

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "mid", "right");
        }
    }

    public static void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            func(n - 1, from, to, mid);
            func(1, from, mid, to);
            func(n - 1, mid, from, to);
        }
    }
}
