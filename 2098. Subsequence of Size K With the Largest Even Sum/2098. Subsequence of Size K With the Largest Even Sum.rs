/*
 * Problem: 2098. Subsequence of Size K With the Largest Even Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subsequence-of-size-k-with-the-largest-even-sum/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn largest_even_sum(nums: Vec<i32>, k: i32) -> i64 {
        let mut nums=nums.clone();
        nums.sort();
        let mut sum:i64=0;
        for i in nums.len()-k as usize..nums.len() {
            sum+=nums[i] as i64;
        }
        if (sum&1)==0 {
            return sum;
        }
        let mut max_even=-1;
        let mut max_odd=-1;
        let mut min_even=-1;
        let mut min_odd=-1;
        let mut idx=nums.len() as i32-k;
        while idx<nums.len() as i32 && (min_even==-1 || min_odd==-1) {
            if (nums[idx as usize]&1)==0 {
                if min_even==-1 {
                    min_even=nums[idx as usize]
                }
            } else {
                if min_odd==-1 {
                    min_odd=nums[idx as usize]
                }
            }
            idx+=1
        }
        idx=nums.len() as i32-k-1;
        while idx>=0 && (max_even==-1 || max_odd==-1) {
            if (nums[idx as usize]&1)==0 {
                if max_even==-1 {
                    max_even=nums[idx as usize]
                }
            } else {
                if max_odd==-1 {
                    max_odd=nums[idx as usize]
                }
            }
            idx-=1
        }
        let mut res: i64=-1;
        if min_even!=-1 && max_odd!=-1 {
            res=res.max(sum-min_even as i64+max_odd as i64)
        }
        if min_odd!=-1 && max_even!=-1 {
            res=res.max(sum-min_odd as i64+max_even as i64)
        }
        return res;
    }
}
