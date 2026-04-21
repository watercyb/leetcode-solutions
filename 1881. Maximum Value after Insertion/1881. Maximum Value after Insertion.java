/*
 * Problem: 1881. Maximum Value after Insertion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-value-after-insertion/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public String maxValue(String n, int x) {
        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) - '0' > x)
                    return new StringBuilder(n.substring(0, i)).append(x).append(n.substring(i)).toString();
            }
            return new StringBuilder(n).append(x).toString();
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) - '0' < x)
                    return new StringBuilder(n.substring(0, i)).append(x).append(n.substring(i)).toString();
            }
            return new StringBuilder(n).append(x).toString();
        }
    }
}
