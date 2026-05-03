/*
 * Problem: 3099. Harshad Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/harshad-number/
 * Language: rust
 * Date: 2026-05-03
 */

impl Solution {
    pub fn sum_of_the_digits_of_harshad_number(x: i32) -> i32 {
        let mut num=x;
        let mut sum=0;
        while num>0 {
            sum+=num%10;
            num/=10;
        }
        if x%sum==0 {
            return sum;
        }
        return -1;
    }
}
