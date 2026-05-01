/*
 * Problem: 2875. Minimum Size Subarray in Infinite Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-size-subarray-in-infinite-array/
 * Language: rust
 * Date: 2026-05-01
 */

use std::collections::HashMap;

impl Solution {
    pub fn min_size_subarray(nums: Vec<i32>, target: i32) -> i32 {
        let mut t=target as i64;
        let mut sum=0 as i64;
        for num in &nums {
            sum+=*num as i64;
        }
        print!("{:?}", sum);
        let mut n=0;
        if sum<=t {
            n=t/sum;
            t%=sum;
        }
        if t==0 {
            return n as i32 * nums.len() as i32;
        }
        let mut map: HashMap<i64, i32> = HashMap::new();
        map.insert(0,-1);
        let mut sum=0 as i64;
        let mut res=i32::MAX;
        for i in 0..nums.len()*2 {
            let idx=i%nums.len();
            sum+=nums[idx] as i64;
            if map.contains_key(&(sum-t)) {
                res=res.min(i as i32-map.get(&(sum-t)).unwrap());
            }
            map.insert(sum,i as i32);
        }
        if res==i32::MAX {
            return -1;
        }
        return res + (n as i32 * nums.len() as i32)
    }
}
