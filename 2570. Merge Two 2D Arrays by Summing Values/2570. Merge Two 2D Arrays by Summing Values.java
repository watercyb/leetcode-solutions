/*
 * Problem: 2570. Merge Two 2D Arrays by Summing Values
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] > nums2[j][0]) {
                list.add(new int[] { nums2[j][0], nums2[j][1] });
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            } else {
                list.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            list.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }
        while (j < nums2.length) {
            list.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
