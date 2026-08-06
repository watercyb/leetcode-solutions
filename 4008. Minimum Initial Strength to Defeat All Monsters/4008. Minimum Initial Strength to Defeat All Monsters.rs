/*
 * Problem: 4008. Minimum Initial Strength to Defeat All Monsters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-initial-strength-to-defeat-all-monsters/
 * Language: rust
 * Date: 2026-08-06
 */

impl Solution {
    pub fn min_initial_strength(monsters: Vec<i32>, boosts: Vec<Vec<i32>>) -> i64 {
        let mut arr:Vec<i64>=vec![0;monsters.len()+1];
        for boost in boosts {
            arr[boost[0] as usize]+=boost[2] as i64;
            arr[boost[1] as usize+1]-=boost[2] as i64;
        }
        let mut sum: i64=0;
        for monster in &monsters {
            sum+=*monster as i64;
        }
        let mut l: i64=0;
        let mut r: i64=sum;
        while l<r {
            let mut mid=(l+r)/2;
            if (Self::chk(&monsters, &arr, mid)) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }

    pub fn chk(monsters: &Vec<i32>, arr:&Vec<i64>, mid: i64) -> bool {
        let mut score=mid;
        let mut sum: i64=0;
        for i in 0..monsters.len() {
            sum+=arr[i] as i64;
            if score+sum<monsters[i] as i64 {
                return false;
            }
            score=(score-monsters[i] as i64).max(0);
        }
        return true;
    }
}
