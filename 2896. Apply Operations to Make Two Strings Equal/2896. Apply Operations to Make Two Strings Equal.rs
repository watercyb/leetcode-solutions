/*
 * Problem: 2896. Apply Operations to Make Two Strings Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-operations-to-make-two-strings-equal/
 * Language: rust
 * Date: 2026-05-01
 */

impl Solution {
    pub fn min_operations(s1: String, s2: String, x: i32) -> i32 {
        let mut chrs1: Vec<char>=s1.chars().collect();
        let mut chrs2: Vec<char>=s2.chars().collect();
        let mut arr: Vec<i32>=Vec::new();
        for i in 0..chrs1.len() {
            if chrs1[i]!=chrs2[i] {
                arr.push(i as i32);
            }
        }
        if arr.len()%2==1 {
            return -1;
        }
        if arr.len()==0 {
            return 0;
        }
        let mut dp=vec![vec![0;arr.len()];arr.len()];
        for i in 0..arr.len() {
            for j in (0..i).rev().step_by(2) {
                let mut min=(arr[i]-arr[j]).min(x)+dp[j+1][i-1];
                for k in (j+1..i).step_by(2) {
                    min=min.min(dp[j][k]+dp[k+1][i]);
                }
                dp[j][i]=min;
            }
        }
        return dp[0][arr.len()-1];
    }
}
