/*
 * Problem: 3622. Check Divisibility by Digit Sum and Product
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/?envType=daily-question&envId=2026-08-22
 * Language: java
 * Date: 2026-08-22
 */

class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int num = n;
        while (num > 0) {
            int dight = num % 10;
            num /= 10;
            sum += dight;
            pro *= dight;
        }
        return n % (sum + pro) == 0;
    }
}
