/*
 * Problem: 1585. Check If String Is Transformable With Substring Sort Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean isTransformable(String s, String t) {
        int[] counts = new int[10];
        char[] chrsS = s.toCharArray();
        for (int i = 0; i < chrsS.length; i++) {
            counts[chrsS[i] - '0']++;
        }
        int[][] arr = new int[10][];
        for (int i = 0; i < 10; i++) {
            arr[i] = new int[counts[i]];
        }
        char[] chrsT = t.toCharArray();
        for (char chr : chrsT) {
            if (counts[chr - '0']-- == 0)
                return false;
        }
        int[] indexes = new int[10];
        for (int i = 0; i < chrsS.length; i++) {
            int idx = chrsS[i] - '0';
            arr[idx][indexes[idx]++] = i;
        }
        Arrays.fill(indexes, 0);
        for (int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';
            if (indexes[digit] == arr[digit].length)
                return false;
            for (int j = 0; j < digit; j++) {
                if (indexes[j] < arr[j].length && arr[j][indexes[j]] < arr[digit][indexes[digit]])
                    return false;
            }
            indexes[digit]++;
        }
        return true;
    }
}
