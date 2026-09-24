/*
 * Problem: 4056. Number of Intersecting Interval Pairs I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/
 * Language: rust
 * Date: 2026-09-24
 */

impl Solution {
    pub fn count_intersecting_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        let mut bit = vec![0; 102];
        let mut arr=intervals;
        arr.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut res=0;
        let mut count=0;
        for pair in &arr {
            res+=count-Self::get(&mut bit, pair[0]-1);
            Self::insert(&mut bit, pair[1]);
            count+=1;
        }
        return res;
    }

    pub fn insert(bit: &mut Vec<i32>, i: i32) {
        let mut i=i;
        i+=1;
        while i<bit.len() as i32 {
            bit[i as usize]+=1;
            i+=i&-i;
        }
    }

    pub fn get(bit: &mut Vec<i32>, i: i32) -> i32 {
        let mut i=i;
        i+=1;
        let mut res=0;
        while i>0 {
            res+=bit[i as usize];
            i-=i&-i;
        }
        return res;
    }
}
