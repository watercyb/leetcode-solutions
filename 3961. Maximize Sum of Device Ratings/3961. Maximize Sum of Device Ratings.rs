/*
 * Problem: 3961. Maximize Sum of Device Ratings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-sum-of-device-ratings/
 * Language: rust
 * Date: 2026-06-24
 */

impl Solution {
    pub fn max_ratings(units: Vec<Vec<i32>>) -> i64 {
        if units[0].len()==1 {
            let mut res=0 as i64;
            for unit in units {
                res+=unit[0] as i64;
            }
            return res;
        } else {
            let mut a=1000000;
            let mut b=1000000;
            let mut sum=0 as i64;
            for unit in units {
                let mut min_1=100000;
                let mut min_2=100000;
                for num in unit {
                    if num<min_1 {
                        min_2=min_1;
                        min_1=num;
                    } else if num<min_2 {
                        min_2=num;
                    }
                }
                a=a.min(min_1);
                b=b.min(min_2);
                sum+=min_2 as i64;
            }
            return sum - b as i64 + a as i64;
        }
    }
}
