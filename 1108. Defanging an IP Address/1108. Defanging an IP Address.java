/*
 * Problem: 1108. Defanging an IP Address
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/defanging-an-ip-address/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder SB = new StringBuilder();
        for (char chr : address.toCharArray()) {
            if (chr == '.') {
                SB.append("[.]");
            } else {
                SB.append(chr);
            }
        }
        return SB.toString();
    }
}
