/*
 * Problem: 3852. Smallest Pair With Different Frequencies
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-pair-with-different-frequencies/
 * Language: rust
 * Date: 2026-05-11
 */

impl Solution {
    pub fn min_distinct_freq_pair(nums: Vec<i32>) -> Vec<i32> {
        let mut counts=[0;101];
        for &num in &nums {
            counts[num as usize]+=1;
        }
        let mut l=1;
        while counts[l]==0 {
            l+=1;
        }
        for r in l+1..=100 {
            if counts[r]!=0 && counts[r]!=counts[l] {
                return vec![l as i32, r as i32];
            }
        }
        return vec![-1, -1];
    }
}
