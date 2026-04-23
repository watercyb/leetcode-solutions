/*
 * Problem: 2085. Count Common Words With One Occurrence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-common-words-with-one-occurrence/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn count_words(mut words1: Vec<String>, mut words2: Vec<String>) -> i32 {
        words1.sort();
        words2.sort();
        let mut res=0;
        let mut i=0;
        let mut j=0;
        while i<words1.len() && j<words2.len() {
            while i<words1.len()-1 && words1[i]==words1[i+1] {
                let temp=&words1[i];
                while i<words1.len() && words1[i]==*temp {
                    i+=1;
                }
            }
            while j<words2.len()-1 && words2[j]==words2[j+1] {
                let temp=&words2[j];
                while j<words2.len() && words2[j]==*temp {
                    j+=1;
                }
            }
            if i==words1.len() || j==words2.len() {
                break;
            }
            if words1[i]<words2[j] {
                i+=1;
            } else if words1[i]>words2[j] {
                j+=1;
            } else {
                res+=1;
                i+=1;
                j+=1;
            }
        }
        return res;
    }
}
