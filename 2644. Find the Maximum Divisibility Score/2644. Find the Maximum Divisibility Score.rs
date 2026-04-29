/*
 * Problem: 2644. Find the Maximum Divisibility Score
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-maximum-divisibility-score/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn max_div_score(nums: Vec<i32>, divisors: Vec<i32>) -> i32 {
        let mut res=1000000000;
        let mut max=0;
        for &divisor in &divisors {
            let mut count=0;
            for &num in &nums {
                if divisor<=num&&num%divisor==0 {
                    count+=1;
                }
            }
            if count>max||(count==max&&divisor<res) {
                max=count;
                res=divisor;
            }
        }
        return res;
    }
}
