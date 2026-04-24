/*
 * Problem: 2113. Elements in Array After Removing and Replacing Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn element_in_nums(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let len=nums.len()*2;
        let mut res:Vec<i32>=Vec::new();
        for query in &queries {
            let time=(query[0] as usize % len);
            let idx=query[1] as usize;
            if time<nums.len() {
                let idx:usize=idx+time;
                if idx>=nums.len() {
                    res.push(-1);
                } else {
                    res.push(nums[idx]);
                }
            } else if time>nums.len() {
                let time:usize=time as usize - nums.len();
                if idx>=time {
                    res.push(-1);
                } else {
                    res.push(nums[idx]);
                }
            } else {
                res.push(-1);
            }
        }
        return res;
    }
}
