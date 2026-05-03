/*
 * Problem: 3032. Count Numbers With Unique Digits II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-numbers-with-unique-digits-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int numberCount(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            if (chk(i))
                res++;
        }
        return res;
    }

    public boolean chk(int num) {
        boolean[] seens = new boolean[10];
        while (num > 0) {
            int idx = num % 10;
            if (seens[idx])
                return false;
            seens[idx] = true;
            num /= 10;
        }
        return true;
    }
}
