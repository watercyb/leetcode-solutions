/*
 * Problem: 2040. Kth Smallest Product of Two Sorted Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    int[] n1a, n1b, n2a, n2b;
    int zeros;

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        inl(nums1, nums2);
        long l = Math.min(
                Math.min((long) nums1[0] * nums2[nums2.length - 1], (long) nums2[0] * nums1[nums1.length - 1]),
                Math.min((long) nums1[0] * nums2[0], nums1[nums1.length - 1] * (long) nums2[nums2.length - 1]));
        long r = Math.max(
                Math.max((long) nums1[0] * nums2[nums2.length - 1], (long) nums2[0] * nums1[nums1.length - 1]),
                Math.max((long) nums1[0] * nums2[0], nums1[nums1.length - 1] * (long) nums2[nums2.length - 1]));
        if (k == 1)
            return l;
        while (l < r) {
            long mid = (r - l) / 2 + l;
            if (chk(k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(long k, long mid) {
        int j = 0;
        if (mid >= 0) {
            k -= zeros;
            if (n1a != null && n2b != null)
                k -= n1a.length * n2b.length;
            if (n1b != null && n2a != null)
                k -= n1b.length * n2a.length;
            if (k <= 0)
                return true;
            if (n1a != null && n2a != null) {
                j = 0;
                n1an2a: for (int i = n1a.length - 1; i >= 0; i--) {
                    while (j < n2a.length && (long) n1a[i] * n2a[j] > mid)
                        j++;
                    if (j == n2a.length)
                        break n1an2a;
                    k -= n2a.length - j;
                    if (k <= 0)
                        return true;
                }
            }
            if (n1b != null && n2b != null) {
                j = n2b.length - 1;
                n1bn2b: for (int i = 0; i < n1b.length; i++) {
                    while (j >= 0 && (long) n1b[i] * n2b[j] > mid)
                        j--;
                    if (j < 0)
                        break n1bn2b;
                    k -= j + 1;
                    if (k <= 0)
                        return true;
                }
            }
        } else {
            if (n1a != null && n2b != null) {
                j = 0;
                n1an2b: for (int i = 0; i < n1a.length; i++) {
                    while (j < n2b.length && (long) n1a[i] * n2b[j] > mid)
                        j++;
                    if (j == n2b.length)
                        break n1an2b;
                    k -= n2b.length - j;
                    if (k <= 0)
                        return true;
                }
            }
            if (n2a != null && n1b != null) {
                j = 0;
                n2an1b: for (int i = 0; i < n2a.length; i++) {
                    while (j < n1b.length && (long) n2a[i] * n1b[j] > mid)
                        j++;
                    if (j == n1b.length)
                        break n2an1b;
                    k -= n1b.length - j;
                    if (k <= 0)
                        return true;
                }
            }
        }
        return false;
    }

    public void inl(int[] nums1, int[] nums2) {
        int x1 = Arrays.binarySearch(nums1, -1);
        if (x1 < 0)
            x1 = -x1 - 1;
        if (x1==nums1.length||nums1[x1] != -1)
            x1--;
        int x2 = Arrays.binarySearch(nums1, 0);
        if (x2 < 0)
            x2 = -x2 - 1;
        if (x2<nums1.length&&nums1[x2] == 0)
            x2++;
        int y1 = Arrays.binarySearch(nums2, -1);
        if (y1 < 0)
            y1 = -y1 - 1;
        if (y1==nums2.length||nums2[y1] != -1)
            y1--;
        int y2 = Arrays.binarySearch(nums2, 0);
        if (y2 < 0)
            y2 = -y2 - 1;
        if (y2<nums2.length&&nums2[y2] == 0)
            y2++;
        zeros = (x2 - x1 - 1) * nums2.length + (y2 - y1 - 1) * nums1.length-(x2 - x1 - 1) * (y2 - y1 - 1);
        if (x1 >= 0&&x1 < nums1.length) {
            n1a = new int[x1 + 1];
            for (int i = 0; i <= x1; i++) {
                n1a[i] = nums1[i];
            }
        }
        if (x2 >= 0&&x2 < nums1.length) {
            n1b = new int[nums1.length - x2];
            for (int i = x2; i < nums1.length; i++) {
                n1b[i - x2] = nums1[i];
            }
        }
        if (y1 >= 0&&y1 < nums2.length) {
            n2a = new int[y1 + 1];
            for (int i = 0; i <= y1; i++) {
                n2a[i] = nums2[i];
            }
        }
        if (y2 >= 0&&y2 < nums2.length) {
            n2b = new int[nums2.length - y2];
            for (int i = y2; i < nums2.length; i++) {
                n2b[i - y2] = nums2[i];
            }
        }
    }
}
