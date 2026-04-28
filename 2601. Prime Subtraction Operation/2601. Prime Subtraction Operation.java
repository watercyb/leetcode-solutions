/*
 * Problem: 2601. Prime Subtraction Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/prime-subtraction-operation/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    static int[] primes;

    public boolean primeSubOperation(int[] nums) {
        if (primes == null) {
            primes = new int[1001];
            for (int i = 2; i < 501; i++) {
                if (primes[i] == -1)
                    continue;
                for (int j = i + i; j <= 1000; j += i) {
                    primes[j] = -1;
                }
            }
            primes[1] = -1;
            int prv = 0;
            for (int i = 0; i <= 1000; i++) {
                if (primes[i] == 0) {
                    primes[i] = prv;
                    prv = i;
                } else {
                    primes[i] = prv;
                }
            }
        }
        int prv = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= prv)
                return false;
            prv = nums[i] - primes[nums[i] - prv];
        }
        return true;
    }
}
