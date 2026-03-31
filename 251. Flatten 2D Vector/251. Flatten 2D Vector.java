/*
 * Problem: 251. Flatten 2D Vector
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flatten-2d-vector/
 * Language: java
 * Date: 2026-03-31
 */

class Vector2D {
    int row = 0;
    int col = 0;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        while (row < vec.length && col == vec[row].length) {
            row++;
        }
    }

    public int next() {
        int res = vec[row][col];
        col++;
        while (row < vec.length && col == vec[row].length) {
            col = 0;
            row++;
        }
        return res;
    }

    public boolean hasNext() {
        return row != vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
