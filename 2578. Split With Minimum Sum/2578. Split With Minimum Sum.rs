/*
 * Problem: 2578. Split With Minimum Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/split-with-minimum-sum/
 * Language: rust
 * Date: 2026-04-28
 */

impl Solution {
    pub fn split_num(mut num: i32) -> i32 {
        let mut nums=[0,0];
        let mut counts=[0;10];
        while num>0 {
            counts[(num%10) as usize]+=1;
            num/=10;
        }
        let mut idx=0;
        for i in 0..=9 {
            for _ in 0..counts[i as usize] {
               nums[idx]=nums[idx]*10+i;
               idx=1-idx;
            }
        }
        return nums[0]+nums[1];
    }
}
