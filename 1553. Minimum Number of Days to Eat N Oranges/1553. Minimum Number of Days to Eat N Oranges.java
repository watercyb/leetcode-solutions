/*
 * Problem: 1553. Minimum Number of Days to Eat N Oranges
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    HashMap<Integer, Integer> HM = new HashMap<>();

    public int minDays(int n) {
        if (n <= 2)
            return n;
        if (HM.containsKey(n))
            return HM.get(n);
        int res = Math.min(minDays(n / 2) + 1 + (n & 1), minDays(n / 3) + 1 + (n % 3));
        HM.put(n, res);
        return res;
    }
}
