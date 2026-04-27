/*
 * Problem: 2431. Maximize Total Tastiness of Purchased Fruits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-total-tastiness-of-purchased-fruits/
 * Language: rust
 * Date: 2026-04-27
 */

impl Solution {
    pub fn max_tastiness(price: Vec<i32>, tastiness: Vec<i32>, max_amount: i32, max_coupons: i32) -> i32 {
        let max_amount = max_amount as usize;
        let max_coupons = max_coupons as usize;
        let mut dp = vec![vec![0; max_coupons + 1]; max_amount + 1];
        for i in 0..price.len() {
            let p = price[i] as usize;
            let half_p = (price[i] / 2) as usize;
            let t = tastiness[i];
            for j in (0..=max_amount).rev() {
                for k in (0..=max_coupons).rev() {
                    let taste=dp[j][k];
                    if j + p <= max_amount {
                        dp[j + p][k] = dp[j + p][k].max(taste + t);
                    }
                    if k < max_coupons && j + half_p <= max_amount {
                        dp[j + half_p][k + 1] =
                            dp[j + half_p][k + 1].max(taste + t);
                    }
                }
            }
        }
        let mut res = 0;
        for i in 0..=max_amount {
            for j in 0..=max_coupons {
                res = res.max(dp[i][j]);
            }
        }
        return res;
    }
}
