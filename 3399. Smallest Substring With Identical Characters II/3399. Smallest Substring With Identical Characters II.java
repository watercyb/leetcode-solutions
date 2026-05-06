/*
 * Problem: 3399. Smallest Substring With Identical Characters II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-substring-with-identical-characters-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minLength(String s, int numOps) {
        if (numOps * 2 >= s.length())
            return 1;
        int[] arr = new int[s.length()];
        int max = 0;
        int prv = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
            if (prv != arr[i]) {
                prv = arr[i];
                max = Math.max(count, max);
                count = 1;
            } else {
                count++;
            }
        }
        int l = 1;
        int r = Math.max(count, max);
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(arr, numOps, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] arr, int numOps, int mid) {
        if (mid == 1)
            return chkOne(arr, numOps, 0) || chkOne(arr, numOps, 1);
        int prv = arr[0];
        int count = 1;
        int prvCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prv) {
                prv = arr[i];
                prvCount = count;
                count = 1;
            } else if (count == mid) {
                if (numOps-- == 0)
                    return false;
                if (i == arr.length - 1 || arr[i + 1] == arr[i] || (prvCount >= mid && count < 2)) {
                    prv = 1 - prv;
                    prvCount = count;
                }
                count = 1;
            } else {
                count++;
            }
        }
        return true;
    }

    public boolean chkOne(int[] arr, int numOps, int prv) {
        for (int num : arr) {
            if (num == prv) {
                if (numOps-- == 0)
                    return false;
                prv = 1 - prv;
            } else {
                prv = num;
            }
        }
        return true;
    }
}
