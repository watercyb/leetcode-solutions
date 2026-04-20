/*
 * Problem: 1725. Number Of Rectangles That Can Form The Largest Square
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        let mut max=0;
        let mut res=0;
        for rec in rectangles {
            let min=rec[0].min(rec[1]);
            if min>max {
                max=min;
                res=1;
            } else if min==max {
                res+=1;
            }
        }
        return res;
    }
}
