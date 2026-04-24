/*
 * Problem: 2189. Number of Ways to Build House of Cards
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-build-house-of-cards/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn house_of_cards(n: i32) -> i32 {
        let mut dp=vec![vec![-1; ((n+1)/3+1) as usize]; (n+1) as usize];
        let res = Self::dfs(&mut dp, n as usize, ((n+1)/3) as usize);
        return res;
    }

    pub fn dfs(dp: &mut Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        if i==0 {
            return 1;
        }
        if j==0 {
            return 0;
        }
        if dp[i][j]!=-1 {
            return dp[i][j];
        }
        let mut count=((i+1)/3).min(j);
        let mut res=0;
        for k in 1..=count {
            res+=Self::dfs(dp, i-(3*k-1), k-1);
        }
        dp[i][j]=res;
        return res;
    }
}
