/*
 * Problem: 3950. Exactly One Consecutive Set Bits Pair
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/
 * Language: rust
 * Date: 2026-06-08
 */

impl Solution {
    pub fn consecutive_set_bits(n: i32) -> bool {
        let mut n=n;
        let mut prv=-1;
        let mut seen=false;
        while n>0 {
            let digit=n&1;
            if digit==prv {
                if seen {
                    return false;
                }
                seen=true;
            }
            prv=digit*2-1;
            n>>=1;
        }
        return seen;
    }
}
