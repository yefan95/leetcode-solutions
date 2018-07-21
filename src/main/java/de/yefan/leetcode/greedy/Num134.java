package de.yefan.leetcode.greedy;

/**
 * Gas Station
 * https://leetcode-cn.com/problems/gas-station/description/
 */
public class Num134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int n = gas.length;
        int total = 0, sum = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }

        return total < 0 ? -1 : index + 1;
    }
}
