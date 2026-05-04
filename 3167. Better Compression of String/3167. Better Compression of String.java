/*
 * Problem: 3167. Better Compression of String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/better-compression-of-string/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public String betterCompression(String compressed) {
        int[] counts = new int['z' + 1];
        char prv = compressed.charAt(0);
        int num = 0;
        for (int i = 1; i < compressed.length(); i++) {
            char chr = compressed.charAt(i);
            if (Character.isDigit(chr)) {
                num = num * 10 + chr - '0';
            } else {
                counts[prv] += num;
                prv = chr;
                num = 0;
            }
        }
        counts[prv] += num;
        StringBuilder SB = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == 0)
                continue;
            SB.append((char) i).append(counts[i]);
        }
        return SB.toString();
    }
}
