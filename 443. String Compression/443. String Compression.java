/*
 * Problem: 443. String Compression
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/string-compression/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int compress(char[] chars) {
        char prv = chars[0];
        int count = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != prv) {
                chars[j++] = prv;
                if (count > 1) {
                    for (char chr : Integer.toString(count).toCharArray()) {
                        chars[j++] = chr;
                    }
                }
                prv = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        chars[j++] = prv;
        if (count > 1) {
            for (char chr : Integer.toString(count).toCharArray()) {
                chars[j++] = chr;
            }
        }
        return j;
    }
}
