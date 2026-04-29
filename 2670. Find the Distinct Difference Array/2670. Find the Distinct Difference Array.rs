/*
 * Problem: 2670. Find the Distinct Difference Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-distinct-difference-array/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn distinct_difference_array(nums: Vec<i32>) -> Vec<i32> {
        let mut seens=[false;51];
        let mut counts=vec![0;nums.len()];
        let mut count=0;
        for i in (0..nums.len()).rev() {
            counts[i]=count;
            if !seens[nums[i] as usize] {
                seens[nums[i] as usize]=true;
                count+=1;
            }
        }
        let mut res=Vec::new();
        let mut seens=[false;51];
        count=0;
        for i in 0..nums.len() {
            if !seens[nums[i] as usize] {
                seens[nums[i] as usize]=true;
                count+=1;
            }
            res.push(count-counts[i]);
        }
        return res;
    }
}
