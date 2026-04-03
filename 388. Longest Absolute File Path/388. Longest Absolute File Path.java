/*
 * Problem: 388. Longest Absolute File Path
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-absolute-file-path/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        Deque<Integer> Dq = new ArrayDeque<>();
        int count = -1;
        int length = 0;
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            int n = 0;
            while (str.charAt(j) == '\t') {
                j++;
                n++;
            }
            int size = str.length() - j;
            if (str.contains(".")) {
                while (n <= count) {
                    length -= Dq.pollLast() + 1;
                    count--;
                }
                res = Math.max(length + size, res);
            } else {
                if (n > count) {
                    int len = size;
                    Dq.offerLast(len);
                    length += len + 1;
                    count++;
                } else {
                    while (n <= count) {
                        length -= Dq.pollLast() + 1;
                        count--;
                    }
                    int len = size;
                    Dq.offerLast(len);
                    length += len + 1;
                    count++;
                }
            }
        }
        return res;
    }
}
