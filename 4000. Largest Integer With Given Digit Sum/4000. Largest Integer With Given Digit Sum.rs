/*
 * Problem: 4000. Largest Integer With Given Digit Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-integer-with-given-digit-sum/
 * Language: rust
 * Date: 2026-07-27
 */

impl Solution {
    pub fn largest_integer(n: i32, s: i32) -> i32 {
        if (s>9*n) {
            return -1;
        }
        if (s==0) {
            return 0;
        }
        let mut s=s;
        let mut res=0;
        for i in 0..n {
            if s>9 {
                res=res*10+9;
                s-=9;
            } else {
                res=res*10+s;
                s=0;
            }
        }
        return res;
    }
}
