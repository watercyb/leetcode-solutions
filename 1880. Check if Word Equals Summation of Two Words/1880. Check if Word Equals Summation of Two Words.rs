/*
 * Problem: 1880. Check if Word Equals Summation of Two Words
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
 * Language: rust
 * Date: 2026-04-21
 */

impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        return Self::get_num(&first_word)+Self::get_num(&second_word)==Self::get_num(&target_word);
    }

    fn get_num(st:&str)->i32 {
        let mut res=0;
        for chr in st.chars() {
            res=res*10 + (chr as u8 - b'a') as i32
        }
        return res;
    }
}
