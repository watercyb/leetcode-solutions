/*
 * Problem: 3023. Find Pattern in Infinite Stream I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-pattern-in-infinite-stream-i/
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
        int[] LPS = getLPS(pattern);
        int num = infiniteStream.next();
        int idx = 0;
        int len = 0;
        while (true) {
            if (num == pattern[len]) {
                if (++len == pattern.length)
                    return idx - pattern.length + 1;
                num = infiniteStream.next();
                idx++;
            } else if (len > 0) {
                len = LPS[len - 1];
            } else {
                num = infiniteStream.next();
                idx++;
            }
        }
    }

    public int[] getLPS(int[] pattern) {
        int[] res = new int[pattern.length];
        int len = 0;
        int idx = 1;
        while (idx < pattern.length) {
            if (pattern[idx] == pattern[len]) {
                res[idx++] = ++len;
            } else if (len > 0) {
                len = res[len - 1];
            } else {
                idx++;
            }
        }
        return res;
    }
}
