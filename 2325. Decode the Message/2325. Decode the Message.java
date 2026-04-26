/*
 * Problem: 2325. Decode the Message
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/decode-the-message/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String decodeMessage(String key, String message) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int idx = 0;
        for (char chr : key.toCharArray()) {
            if (chr == ' ')
                continue;
            int n = chr - 'a';
            if (arr[n] == -1)
                arr[n] = idx++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == -1)
                arr[i] = i;
        }
        StringBuilder SB = new StringBuilder();
        for (char chr : message.toCharArray()) {
            if (chr == ' ') {
                SB.append(chr);
            } else {
                SB.append((char) (arr[chr - 'a'] + 'a'));
            }
        }
        return SB.toString();
    }
}
