/*
 * Problem: 3919. Minimum Cost to Move Between Indices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-move-between-indices/
 * Language: rust
 * Date: 2026-05-05
 */

impl Solution {
    pub fn min_cost(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let mut lefts=vec![0;nums.len()];
        let mut rights=vec![0;nums.len()];
        let mut left=0;
        for i in 1..nums.len()-1 {
            if nums[i]-nums[i-1]<=nums[i+1]-nums[i] {
                left+=1;
            } else {
                left+=nums[i]-nums[i-1];
            }
            lefts[i]=left;
        }
        lefts[nums.len()-1]=left+1;
        let mut right=0;
        for i in (1..nums.len()-1).rev() {
            if nums[i]-nums[i-1]>nums[i+1]-nums[i] {
                right+=1;
            } else {
                right+=nums[i+1]-nums[i];
            }
            rights[i]=right;
        }
        rights[0]=right+1;
        let mut res: Vec<i32>=Vec::new();
        for query in &queries {
            let l=query[0] as usize;
            let r=query[1] as usize;
            if (l<=r) {
                res.push(rights[l]-rights[r]);
            } else {
                res.push(lefts[l]-lefts[r]);
            }
        }
        return res;
    }
}
