/*
 * Problem: 3921. Score Validator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/score-validator/
 * Language: csharp
 * Date: 2026-05-12
 */

public class Solution {
    public int[] ScoreValidator(string[] events) {
        int[] res=new int[2];
        foreach (string ev in events) {
            if (ev=="W") {
                res[1]++;
                if (res[1]==10) break;
            } else if (ev.Length==2) {
                res[0]++;
            } else {
                res[0]+=ev[0]-'0';
            }
        }
        return res;
    }
}
