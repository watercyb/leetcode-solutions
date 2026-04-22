/*
 * Problem: 1954. Minimum Garden Perimeter to Collect Enough Apples
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
 * Language: rust
 * Date: 2026-04-22
 */

impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        let mut l: i64=1;
        let mut r: i64=100000;
        while l<r {
           let mid=(l+r)/2;
           if mid*(mid+1)*(2*mid+1)*2>=needed_apples {
            r=mid;
           } else {
            l=mid+1;
           }
        }
        return l*8;
    }
}
