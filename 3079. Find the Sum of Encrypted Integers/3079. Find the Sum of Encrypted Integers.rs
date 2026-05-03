/*
 * Problem: 3079. Find the Sum of Encrypted Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-sum-of-encrypted-integers/
 * Language: rust
 * Date: 2026-05-03
 */

impl Solution {
    pub fn sum_of_encrypted_int(nums: Vec<i32>) -> i32 {
        let mut res=0;
        for num in &nums {
            let mut count=0;
            let mut max_digit=0;
            let mut n=*num;
            while n>0 {
                count+=1;
                max_digit=max_digit.max(n%10);
                n/=10;
            }
            for i in 0..count {
                res+=max_digit;
                max_digit*=10;
            }
        }
        return res;
    }
}
