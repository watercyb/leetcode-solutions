/*
 * Problem: 3847. Find the Score Difference in a Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-score-difference-in-a-game/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int ScoreDifference(int[] nums) {
        int res=0;
        int sign=1;
        for (int i=0;i<nums.Length;i++){
            if (((nums[i]&1)==1)^(i%6==5)) {
                sign=-sign;
            }
            res+=nums[i]*sign;
        }
        return res;
    }
}
