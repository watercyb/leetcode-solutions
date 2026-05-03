/*
 * Problem: 3037. Find Pattern in Infinite Stream II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-pattern-in-infinite-stream-ii/
 * Language: java
 * Date: 2026-05-03
 */

/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        if (pattern.length == 1) {
            int res = 0;
            while (infiniteStream.next() != pattern[0]) {
                res++;
            }
            return res;
        }
        int[] LPS = new int[pattern.length];
        int len = 0;
        int idx = 1;
        while (idx < pattern.length) {
            if (pattern[idx] == pattern[len]) {
                LPS[idx++] = ++len;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        int num = infiniteStream.next();
        int res = 0;
        len = 0;
        while (true) {
            if (num == pattern[len]) {
                if (++len == pattern.length)
                    return res - pattern.length + 1;
                num = infiniteStream.next();
                res++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    num = infiniteStream.next();
                    res++;
                }
            }
        }
    }
}
