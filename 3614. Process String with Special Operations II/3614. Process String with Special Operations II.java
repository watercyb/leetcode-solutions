/*
 * Problem: 3614. Process String with Special Operations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/process-string-with-special-operations-ii/?envType=daily-question&envId=2026-06-17
 * Language: java
 * Date: 2026-06-17
 */

class Solution {
    public char processStr(String s, long k) {
        char[] chrs = s.toCharArray();
        long count = 0;
        for (char chr : chrs) {
            if (chr == '*') {
                if (count > 0)
                    count--;
            } else if (chr == '#') {
                count *= 2;
            } else if (chr != '%') {
                count++;
            }
        }
        k++;
        if (count < k)
            return '.';
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (chrs[i] == '*') {
                count++;
            } else if (chrs[i] == '#') {
                long h = count / 2;
                if (k > h)
                    k -= h;
                count /= 2;
            } else if (chrs[i] == '%') {
                k = count + 1 - k;
            } else {
                if (k == count)
                    return chrs[i];
                count--;
            }
        }
        return '.';
    }
}
