package de.yefan.leetcode.string;

import java.util.*;

/**
 * Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 */
public class Num71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {

            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                System.out.println(dir);
                stack.push(dir);
            }
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            result = sb.append("/" + dir + result).toString();
        }
        return result.isEmpty() ? "/" : result;
    }

    public String simplifyPath1(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList<>(s);
        return "/" + String.join("/", list);
    }

    public static void main(String[] args) {
        Num71 num71 = new Num71();
        String path = "/a/./b/../../c/";
        String res = num71.simplifyPath(path);
        System.out.println(res);
    }
}
