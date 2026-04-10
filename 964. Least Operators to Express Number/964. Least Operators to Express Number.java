/*
 * Problem: 964. Least Operators to Express Number
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/least-operators-to-express-number/
 * Language: java
 * Date: 2026-04-10
 */


class Solution {

    public int leastOpsExpressTarget(int x, int target) {
        int mod = target % x;
        int p = Math.min(2 * mod, (x - mod) * 2 + 1) - 1;
        int n = Math.min(2 * (x - mod), mod * 2 + 1) - 1;
        target /= x;
        int count = 1;
        while (target > 0) {
            mod = target % x;
            int pNext1 = mod * count + p;
            int pNext2 = (mod + 1) * count + n;
            int nNext1 = (x - mod) * count + p;
            int nNext2 = (x - mod - 1) * count + n;
            p = Math.min(pNext1, pNext2);
            n = Math.min(nNext1, nNext2);
            target /= x;
            count++;
        }
        return Math.min(p, n + count);
    }
}
