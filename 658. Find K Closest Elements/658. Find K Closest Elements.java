/*
 * Problem: 658. Find K Closest Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-k-closest-elements/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = Math.max(arr[arr.length - 1] - x,x-arr[0]);
        int idxL = 0;
        int idxR = 0;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            idxL = chkL(arr, x - mid);
            idxR = chkR(arr, x + mid);
            if (idxR - idxL >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        idxL = chkL(arr, x - l);
        idxR = chkR(arr, x + l);
        while (idxR - idxL > k) {
            if (Math.abs(x-arr[idxL])>Math.abs(arr[idxR-1]-x)) {
                idxL++;
            } else {
                idxR--;
            }
        }
        for (int i = idxL; i < idxR; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    public int chkL(int[] arr, int n) {
        if (n < arr[0])
            return 0;
        if (n >= arr[arr.length - 1])
            return arr.length - 1;
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int chkR(int[] arr, int n) {
        if (n < arr[0])
            return -1;
        if (n >= arr[arr.length - 1])
            return arr.length;
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] > n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
