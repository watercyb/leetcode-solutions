/*
 * Problem: 4048. Count Values With Equally Spaced Occurrences I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/
 * Language: rust
 * Date: 2026-09-15
 */

impl Solution {
    pub fn count_special_integers(nums: Vec<i32>) -> i32 {
        let mut res=0;
        let mut list: [Vec<usize>; 101] = std::array::from_fn(|_| Vec::new());
        for i in 0..nums.len() {
            list[nums[i] as usize].push(i);
        }
        for i in 0..list.len() {
            if list[i].len()==3 && list[i][1]-list[i][0]==list[i][2]-list[i][1] {
                res+=1;
            }
        }
        return res;
    }
}
