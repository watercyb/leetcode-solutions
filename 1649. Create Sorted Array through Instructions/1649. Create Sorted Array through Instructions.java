/*
 * Problem: 1649. Create Sorted Array through Instructions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/create-sorted-array-through-instructions/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int createSortedArray(int[] instructions) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int instruction : instructions) {
            max = Math.max(instruction, max);
        }
        BIT = new int[max + 1];
        long res = 0;
        for (int i = 0; i < instructions.length; i++) {
            res += Math.min(i - get(instructions[i]), get(instructions[i] - 1));
            insert(instructions[i]);
        }
        return (int) (res % mod);
    }

    int[] BIT;

    public void insert(int i) {
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
