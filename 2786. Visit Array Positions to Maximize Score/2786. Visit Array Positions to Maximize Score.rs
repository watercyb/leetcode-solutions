/*
 * Problem: 2786. Visit Array Positions to Maximize Score
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/visit-array-positions-to-maximize-score/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn max_score(nums: Vec<i32>, x: i32) -> i64 {
        let mut even: i64=0;
        let mut odd: i64=0;
        if nums[0]%2==0 {
            even=nums[0] as i64;
            odd=i64::MIN/2;
        } else {
            even=i64::MIN/2;
            odd=nums[0] as i64;
        }
        let mut x=x as i64;
        for i in 1..nums.len() {
            let num=nums[i] as i64;
            if num%2==0 {
                even=even.max(odd-x)+num;
            } else {
                odd=odd.max(even-x)+num;
            }
        }
        return even.max(odd);
    }
}
