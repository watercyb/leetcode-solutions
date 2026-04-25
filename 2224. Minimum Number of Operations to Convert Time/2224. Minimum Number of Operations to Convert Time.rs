/*
 * Problem: 2224. Minimum Number of Operations to Convert Time
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn convert_time(current: String, correct : String) -> i32 {    
        let chars1: Vec<char> = current.chars().collect();
        let chars2: Vec<char> = correct.chars().collect();
        let mut res=(chars2[0] as i32-chars1[0] as i32)*10+(chars2[1] as i32-chars1[1] as i32);
        let mut sum=(chars2[3] as i32-chars1[3] as i32)*10+(chars2[4] as i32-chars1[4] as i32);
        if sum<0 {
            sum+=60;
            res-=1;
        }
        res+=sum/15;
        sum%=15;
        res+=sum/5;
        sum%=5;
        res+=sum;
        return res;
    }
}
