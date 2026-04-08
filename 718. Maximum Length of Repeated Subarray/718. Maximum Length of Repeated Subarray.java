/*
 * Problem: 718. Maximum Length of Repeated Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int l = 1;
        int r = Math.min(nums1.length, nums2.length) + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(nums1, nums2, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    int mod = 1_000_000_007;

    public boolean chk(int[] nums1, int[] nums2, int mid) {
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        long h = 0;
        long base = 1;
        for (int i = 0; i < mid - 1; i++) {
            h = (h * 101 + nums1[i]) % mod;
            base = base * 101 % mod;
        }
        h = (h * 101 + nums1[mid - 1]) % mod;
        if (!HM.containsKey((int) h)) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            HM.put((int) h, list);
        } else {
            HM.get((int) h).add(0);
        }
        for (int i = mid; i < nums1.length; i++) {
            h = ((h - base * (nums1[i - mid]) % mod + mod) * 101 + nums1[i]) % mod;
            if (!HM.containsKey((int) h)) {
                List<Integer> list = new ArrayList<>();
                list.add(i - mid + 1);
                HM.put((int) h, list);
            } else {
                HM.get((int) h).add(i - mid + 1);
            }
        }
        h = 0;
        for (int i = 0; i < mid; i++) {
            h = (h * 101 + nums2[i]) % mod;
        }
        if (HM.containsKey((int) h)) {
            for (int idx : HM.get((int) h)) {
                if (cmp(nums1, nums2, idx, 0, mid))
                    return true;
            }
        }
        for (int i = mid; i < nums2.length; i++) {
            h = ((h - base * (nums2[i - mid]) % mod + mod) * 101 + nums2[i]) % mod;
            if (HM.containsKey((int) h)) {
                for (int idx : HM.get((int) h)) {
                    if (cmp(nums1, nums2, idx, i - mid + 1, mid))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean cmp(int[] nums1, int[] nums2, int i, int j, int n) {
        int lim = i + n;
        while (i < lim) {
            if (nums1[i] != nums2[j])
                return false;
            i++;
            j++;
        }
        return true;
    }
}
