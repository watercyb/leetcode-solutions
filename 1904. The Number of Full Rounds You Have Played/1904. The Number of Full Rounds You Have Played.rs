/*
 * Problem: 1904. The Number of Full Rounds You Have Played
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
 * Language: rust
 * Date: 2026-04-22
 */

impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        let mut a=Solution::getTime(login_time);
        let mut b=Solution::getTime(logout_time);
        if b<a {
            b+=24*60;
        }
        return (b/15-(a+14)/15).max(0);
    }
    
    pub fn getTime(time:String)->i32 {
        let chrs:Vec<char>=time.chars().collect();
        return chrs[0].to_digit(10).unwrap() as i32*600+chrs[1].to_digit(10).unwrap() as i32*60+chrs[3].to_digit(10).unwrap() as i32*10+chrs[4].to_digit(10).unwrap() as i32;
    }
}
