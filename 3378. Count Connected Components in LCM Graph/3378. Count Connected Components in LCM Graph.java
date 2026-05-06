/*
 * Problem: 3378. Count Connected Components in LCM Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-connected-components-in-lcm-graph/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countComponents(int[] nums, int threshold) {
        int[] links = new int[nums.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        int[] arr = new int[threshold + 1];
        Arrays.fill(arr, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold)
                continue;
            if (arr[nums[i]] == -1) {
                arr[nums[i]] = i;
            } else {
                links[find(links, arr[nums[i]])] = i;
                continue;
            }
            for (int j = 2 * nums[i]; j <= threshold; j += nums[i]) {
                if (arr[j] == -1) {
                    arr[j] = i;
                } else {
                    links[find(links, arr[j])] = i;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (find(links, i) == i)
                res++;
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
