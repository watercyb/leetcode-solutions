/*
 * Problem: 2586. Count the Number of Vowel Strings in Range
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
 * Language: rust
 * Date: 2026-04-28
 */

impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        let mut res=0;
        for i in left..=right {
            let chrs:Vec<char>=words[i as usize].chars().collect();
            if Self::chk(chrs[0]) && Self::chk(chrs[chrs.len()-1]) {
                res+=1;
            }
        }
        return res;
    }

    pub fn chk(chr: char) -> bool {
        return chr=='a'||chr=='e'||chr=='i'||chr=='o'||chr=='u';
    }
}
