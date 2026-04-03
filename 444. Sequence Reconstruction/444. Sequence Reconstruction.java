/*
 * Problem: 444. Sequence Reconstruction
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sequence-reconstruction/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        boolean[] noMoveRights = new boolean[nums.length + 1];
        int[] indexes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            indexes[nums[i]] = i + 1;
        }
        for (List<Integer> seq : sequences) {
            int prv = 0;
            for (int num : seq) {
                if (indexes[num] <= prv)
                    return false;
                if (indexes[num] == prv + 1)
                    noMoveRights[prv] = true;
                prv = indexes[num];
            }
        }
        for (int i = 2; i <= nums.length; i++) {
            if (!noMoveRights[i - 1])
                return false;
        }
        return true;
    }
}
