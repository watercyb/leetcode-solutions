/*
 * Problem: 2197. Replace Non-Coprime Numbers in Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/replace-non-coprime-numbers-in-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (idx > 0) {
                int gcd = getGCD(num, nums[idx - 1]);
                if (gcd == 1)
                    break;
                num = num / gcd * nums[idx - 1];
                idx--;
            }
            nums[idx++] = num;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    public int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}
