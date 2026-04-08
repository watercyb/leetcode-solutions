/*
 * Problem: 728. Self Dividing Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/self-dividing-numbers/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (chk(i))
                res.add(i);
        }
        return res;
    }

    public boolean chk(int i) {
        int num = i;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || i % digit != 0)
                return false;
            num /= 10;
        }
        return true;
    }
}
