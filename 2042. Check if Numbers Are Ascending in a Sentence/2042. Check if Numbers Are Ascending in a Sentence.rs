/*
 * Problem: 2042. Check if Numbers Are Ascending in a Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        let strs: Vec<&str>=s.split(" ").collect();
        let mut prv=-1;
        for st in strs {
            let res=st.parse();
            if res.is_ok() {
                let num=res.unwrap();
                if num<=prv {
                    return false;
                }
                prv=num;
            }
        }
        return true;
    }
}
