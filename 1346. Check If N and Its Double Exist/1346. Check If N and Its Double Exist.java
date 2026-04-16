/*
 * Problem: 1346. Check If N and Its Double Exist
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] seens = new boolean[6001];
        for (int num : arr) {
            if (seens[num * 2 + 2000])
                return true;
            if (num % 2 == 0 && seens[num / 2 + 2000])
                return true;
            seens[num + 2000] = true;
        }
        return false;
    }
}
