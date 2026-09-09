/*
 * Problem: 3871. Count Commas in Range II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-commas-in-range-ii/?envType=daily-question&envId=2026-09-09
 * Language: swift
 * Date: 2026-09-09
 */

class Solution {
    func countCommas(_ n: Int) -> Int {
        var base=1000;
        var res=0;
        while base<=n {
            res+=n-base+1;
            base*=1000;
        }
        return res;
    }
}
