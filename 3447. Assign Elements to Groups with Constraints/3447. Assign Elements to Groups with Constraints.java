/*
 * Problem: 3447. Assign Elements to Groups with Constraints
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int max = 0;
        for (int num : groups) {
            max = Math.max(num, max);
        }
        int[] res = new int[groups.length];
        int[] arr = new int[max + 1];
        Arrays.fill(arr, -1);
        Arrays.fill(res, -1);
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > max || arr[elements[i]] != -1)
                continue;
            for (int j = elements[i]; j <= max; j += elements[i]) {
                if (arr[j] == -1)
                    arr[j] = i;
            }
        }
        for (int i = 0; i < groups.length; i++) {
            res[i] = arr[groups[i]];
        }
        return res;
    }
}
