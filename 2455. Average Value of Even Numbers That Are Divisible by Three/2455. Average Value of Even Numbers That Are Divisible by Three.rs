/*
 * Problem: 2455. Average Value of Even Numbers That Are Divisible by Three
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
 * Language: rust
 * Date: 2026-04-27
 */

impl Solution {
    pub fn average_value(nums: Vec<i32>) -> i32 {
        let mut sum=0;
        let mut count=0;
        for num in nums {
            if num%6==0 {
                sum+=num;
                count+=1;
            }
        }
        if count==0 {
            return 0;
        }
        return sum/count;
    }
}
