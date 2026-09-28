/*
 * Problem: 4066. Maximum Equal Adjacent Pairs After at Most One Replacement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/
 * Language: csharp
 * Date: 2026-09-28
 */

public class Solution {
    public int MaxEqualAdjacentPairs(int[] nums) {
        Dictionary<int, Dictionary<int, int>> diffCounts = new Dictionary<int, Dictionary<int, int>>();
        int same=0;
        for (int i=0;i<nums.Length;i++) {
            if (i>0) {
                if (nums[i]==nums[i-1]) {
                    same++;
                } else {
                    if (!diffCounts.ContainsKey(nums[i])) {
                        diffCounts[nums[i]]=new Dictionary<int, int>();
                    }
                    increase(diffCounts[nums[i]], nums[i-1]);
                }
            }
            if (i<nums.Length-1) {
                if (nums[i]!=nums[i+1]) {
                    if (!diffCounts.ContainsKey(nums[i])) {
                        diffCounts[nums[i]]=new Dictionary<int, int>();
                    }
                    increase(diffCounts[nums[i]], nums[i+1]);
                }
            }
        }
        int res=same;
        foreach (var val in diffCounts.Values) {
            foreach (var v in val.Values) {
                res=Math.Max(res, same+v);
            }
        }
        return res;
    }

    public void increase(Dictionary<int, int> dict, int i) {
        if (dict.TryGetValue(i, out var val)) {
            dict[i]=val+1;
        } else {
            dict[i]=1;
        }
    }
}
