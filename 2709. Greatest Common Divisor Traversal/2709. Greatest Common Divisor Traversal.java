/*
 * Problem: 2709. Greatest Common Divisor Traversal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/greatest-common-divisor-traversal/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1)
            return true;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                return false;
            max = Math.max(nums[i], max);
        }
        boolean[] has = new boolean[max + 1];
        for (int i = 0; i < nums.length; i++) {
            has[nums[i]] = true;
        }
        int[] links = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            links[i] = i;
        }
        boolean[] seen = new boolean[max + 1];
        int hlf = max / 2;
        for (int i = 2; i <= hlf; i++) {
            if (seen[i])
                continue;
            for (int j = i; j <= max; j += i) {
                seen[j] = true;
                if (has[j])
                    insert(links, i, j);
            }
        }
        int chk = getFirst(links, nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (chk != getFirst(links, nums[i]))
                return false;
        }
        return true;
    }

    public void insert(int[] links, int i, int j) {
        i = getFirst(links, i);
        j = getFirst(links, j);
        if (i > j) {
            links[i] = j;
        } else {
            links[j] = i;
        }
    }

    public int getFirst(int[] links, int i) {
        while (links[i] != i) {
            i = links[i];
        }
        return i;
    }
}
