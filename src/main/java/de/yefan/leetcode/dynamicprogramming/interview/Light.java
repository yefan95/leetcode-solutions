package de.yefan.leetcode.dynamicprogramming.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai ，每盏灯可以覆盖到的最远距离为d，为了照明需求，
 * 所有灯的灯光必须覆盖整条街，但是为了省电，要使这个d最小，请找到这个最小的d。
 */
public class Light {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n;      //路灯个数
        int l;      //街道长度
        int dMax;       //最长间距

        while (reader.hasNext()) {
            //逐行读取提高效率防止超时
            String[] str = reader.nextLine().split(" ");
            n = Integer.parseInt(str[0]);
            l = Integer.parseInt(str[1]);
            //路灯坐标
            int[] a = new int[n];
            String[] s = reader.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            dMax = 0;
            Arrays.sort(a);
            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] > dMax) {
                    dMax = a[i] - a[i - 1];
                }
            }
            //对街道首尾进行添加比较！
            int disMin = Math.max(dMax, 2 * Math.max(a[0] - 0, l - a[n - 1]));
            System.out.println(String.format("%.2f", disMin / 2.0));
        }

    }


}
