/*
 * Problem: 1570. Dot Product of Two Sparse Vectors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 * Language: java
 * Date: 2026-04-18
 */

class SparseVector {
    List<int[]> Li = new ArrayList<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                Li.add(new int[] { i, nums[i] });
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < Li.size() && j < vec.Li.size()) {
            int[] a = Li.get(i);
            int[] b = vec.Li.get(j);
            if (a[0] < b[0]) {
                i++;
            } else if (a[0] > b[0]) {
                j++;
            } else {
                res += a[1] * b[1];
                i++;
                j++;
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
