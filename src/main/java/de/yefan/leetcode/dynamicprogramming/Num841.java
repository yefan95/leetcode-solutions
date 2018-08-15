package de.yefan.leetcode.dynamicprogramming;

import java.util.List;

/**
 * Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class Num841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 0) {
            return false;
        }

        boolean[] visited = new boolean[rooms.size()];

        helper(rooms, visited, 0);

        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }

        return true;
    }

    private void helper(List<List<Integer>> rooms, boolean[] visited, int curRoom) {
        if (visited[curRoom]) {
            return;
        }
        visited[curRoom] = true;
        List<Integer> curRoomKeys = rooms.get(curRoom);
        for (int room : curRoomKeys) {
            helper(rooms, visited, room);
        }
    }
}
