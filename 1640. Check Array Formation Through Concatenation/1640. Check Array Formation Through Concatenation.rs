/*
 * Problem: 1640. Check Array Formation Through Concatenation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-array-formation-through-concatenation/
 * Language: rust
 * Date: 2026-04-19
 */

impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        let mut dp: Vec<bool>=vec![false;arr.len()+1];
        dp[0]=true;
        for i in 0..arr.len() {
            if !dp[i] {
                continue;
            }
            for piece in &pieces {
                if i+piece.len()>arr.len() {
                    continue;
                }
                if chk(&arr, &piece, i) {
                    dp[i+piece.len()]=true;
                }
            }
        }

        fn chk(arr: &Vec<i32>, piece: &Vec<i32>, i: usize) -> bool {
            for j in 0..piece.len() {
                if arr[i+j]!=piece[j] {
                    return false;
                }
            }
            return true;
        }
        
        return dp[dp.len()-1];
    }
}
