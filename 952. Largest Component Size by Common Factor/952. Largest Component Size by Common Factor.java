/*
 * Problem: 952. Largest Component Size by Common Factor
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/largest-component-size-by-common-factor/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] links = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            links[i] = i;
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num] = 1;
        }
        for (int i = 2; i <= max / 2; i++) {
            if (links[i] != i)
                continue;
            for (int j = 2 * i; j <= max; j += i) {
                if (counts[j] == 0)
                    continue;
                int a = unionFind(links, i);
                int b = unionFind(links, j);
                if (a != b) {
                    links[b] = a;
                    counts[a] += counts[b];
                }
            }
        }
        int res = 0;
        for (int count : counts) {
            res = Math.max(count, res);
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
