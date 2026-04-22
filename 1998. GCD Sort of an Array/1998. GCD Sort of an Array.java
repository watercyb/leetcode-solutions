/*
 * Problem: 1998. GCD Sort of an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/gcd-sort-of-an-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int[] links = new int[max + 1];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        int lim = max / 2;
        for (int i = 2; i <= lim; i++) {
            if (unionFind(links, i) != i)
                continue;
            for (int j = i + i; j <= max; j += i) {
                if (counts[j] == 0)
                    continue;
                links[unionFind(links, j)] = unionFind(links, i);
            }
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            counts[idx]--;
            if (unionFind(links, nums[i]) != unionFind(links, idx))
                return false;
        }
        return true;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
