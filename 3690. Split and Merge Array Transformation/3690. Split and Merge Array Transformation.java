/*
 * Problem: 3690. Split and Merge Array Transformation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-and-merge-array-transformation/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int h = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (HM.containsKey(nums1[i])) {
                nums1[i] = HM.get(nums1[i]);
            } else {
                int idx = HM.size();
                HM.put(nums1[i], idx);
                nums1[i] = idx;
            }
            h += nums1[i] << (3 * i);
        }
        int target = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (HM.containsKey(nums2[i])) {
                nums2[i] = HM.get(nums2[i]);
            } else {
                int idx = HM.size();
                HM.put(nums2[i], idx);
                nums2[i] = idx;
            }
            target += nums2[i] << (3 * i);
        }
        int[] Qu = new int[(int) Math.pow(nums1.length, nums1.length)];
        boolean[] seens = new boolean[1 << (3 * nums1.length)];
        int l = 0;
        int r = 1;
        Qu[0] = h;
        seens[h] = true;
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int current = Qu[l++];
                if (current == target)
                    return stp;
                int[] arr = getArr(current, nums1.length);
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i; j < arr.length - 1; j++) {
                        for (int k = j + 1; k < arr.length; k++) {
                            int hNext = getH(arr, i, j, k);
                            if (!seens[hNext]) {
                                seens[hNext] = true;
                                Qu[r++] = hNext;
                            }
                        }
                    }
                }
            }
            stp++;
        }
        return -1;
    }

    public int[] getArr(int h, int n) {
        int div = 1 << 3;
        int[] res = new int[n];
        int idx = 0;
        while (h > 0) {
            res[idx++] = h % div;
            h /= div;
        }
        return res;
    }

    public int getH(int[] arr, int i, int j, int k) {
        int res = 0;
        int idx = 0;
        for (int l = 0; l < i; l++) {
            res += arr[l] << idx;
            idx += 3;
        }
        for (int l = j + 1; l <= k; l++) {
            res += arr[l] << idx;
            idx += 3;
        }
        for (int l = i; l <= j; l++) {
            res += arr[l] << idx;
            idx += 3;
        }
        for (int l = k + 1; l < arr.length; l++) {
            res += arr[l] << idx;
            idx += 3;
        }
        return res;
    }
}
