/*
 * Problem: 1694. Reformat Phone Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reformat-phone-number/
 * Language: rust
 * Date: 2026-04-19
 */

impl Solution {
    pub fn reformat_number(number: String) -> String {
        let mut chrs:Vec<char>=Vec::new();
        let mut idx=0;
        for num in number.chars() {
            if num.is_digit(10) {
                chrs.push(num);
                idx+=1;
                if idx%3==0 {
                    chrs.push('-');
                }
            }
        }
        let len = chrs.len(); 
        if chrs[len-1]=='-' {
            chrs.pop();
        } else if chrs[len-2]=='-' {
            chrs[len-2]=chrs[len-3];
            chrs[len-3]='-';
        }
        return chrs.iter().collect();
    }
}
