/*
 * Problem: 3697. Compute Decimal Representation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/compute-decimal-representation/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] decimalRepresentation(int n) {
        int base = 1;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0)
                list.add(digit * base);
            n /= 10;
            base *= 10;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - 1 - i);
        }
        return res;
    }
}
