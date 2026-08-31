/*
 * Problem: 4038. Count Integers Appearing in a Single Block
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-integers-appearing-in-a-single-block/
 * Language: rust
 * Date: 2026-08-31
 */

impl Solution {
    pub fn count_special_integers(nums: Vec<i32>) -> i32 {
        let mut counts=[0;101];
        counts[nums[0] as usize]=1;
        for i in 1..nums.len() {
            if nums[i]!=nums[i-1] {
                counts[nums[i] as usize]+=1;
            }
        }
        let mut res=0;
        for count in counts {
            if count==1 {
                res+=1;
            }
        }
        return res;
    }
}
