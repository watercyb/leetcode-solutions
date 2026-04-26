/*
 * Problem: 2387. Median of a Row Wise Sorted Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/
 * Language: rust
 * Date: 2026-04-26
 */

impl Solution {
    pub fn matrix_median(grid: Vec<Vec<i32>>) -> i32 {
        let mut l=0;
        let mut r=1000000;
        let m=grid.len();
        let n=grid[0].len();
        let target=m*n/2;
        while l<r {
            let mid=(l+r)>>1;
            let mut count=0;
            for row in &grid {
                let mut left=0;
                let mut right=n;
                while left<right {
                    let middle=(left+right)>>1;
                    if row[middle]>mid {
                        right=middle;
                    } else {
                        left=middle+1;
                    }
                }
                count+=left;
            }
            if count>target {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }
}
