/*
 * Problem: 3033. Modify the Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/modify-the-matrix/
 * Language: rust
 * Date: 2026-05-03
 */

impl Solution {
    pub fn modified_matrix(mut matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        for i in 0..matrix[0].len() {
            let mut max=0;
            let mut has=false;
            for j in 0..matrix.len() {
                max=max.max(matrix[j][i]);
                if matrix[j][i]==-1 {
                    has=true;
                }
            }
            if (has) {
                for j in 0..matrix.len() {
                    if matrix[j][i]==-1 {
                        matrix[j][i]=max;
                    }
                }
            }
        }
        return matrix;
    }
}
