/*
 * Problem: 1153. String Transforms Into Another String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/string-transforms-into-another-string/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        int[] changes = new int[26];
        Arrays.fill(changes, -1);
        boolean[] seens = new boolean[26];
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            int a = str1.charAt(i) - 'a';
            int b = str2.charAt(i) - 'a';
            if (changes[a] == -1) {
                changes[a] = b;
                if (!seens[b]) {
                    count++;
                    seens[b] = true;
                }
            } else if (changes[a] != b) {
                return false;
            }
        }
        return count < 26;
    }
}
