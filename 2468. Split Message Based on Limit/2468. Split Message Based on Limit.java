/*
 * Problem: 2468. Split Message Based on Limit
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/split-message-based-on-limit/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public String[] splitMessage(String message, int limit) {
        var n = message.length();
        for (int i = 1, tail_len;; i++) {
            int cap = 0;
            if (i < 10) {
                tail_len = 5;
            } else if (i < 100) {
                if (i == 10) {
                    cap = cap - 9;
                }
                tail_len = 7;
            } else if (i < 1000) {
                if (i == 100) {
                    cap = cap - 99;
                }
                tail_len = 9;
            } else {
                if (i == 1000) {
                    cap = cap - 999;
                }
                tail_len = 11;
            }
            if (tail_len >= limit) {
                return new String[] {};
            }
            cap += limit - tail_len;
            if (cap < n)
                continue;

            var ans = new String[i];
            for (int j = 0, k = 0; j < i; j++) {
                var tail = "<" + (j + 1) + "/" + i + ">";
                if (j == i - 1) {
                    ans[j] = message.substring(k) + tail;
                } else {
                    var m = limit - tail.length();
                    ans[j] = message.substring(k, k + m) + tail;
                    k += m;
                }
            }
            return ans;
        }
    }
}
