/*
 * Problem: 3766. Minimum Operations to Make Binary Palindrome
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-binary-palindrome/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    static int[] arr;

    public int[] minOperations(int[] nums) {
        if (arr == null)
            getArr();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = arr.length;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (arr[mid] > nums[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == arr.length) {
                res[i] = nums[i] - arr[arr.length - 1];
            } else if (l == 0) {
                res[i] = arr[0] - nums[i];
            } else {
                res[i] = Math.min(nums[i] - arr[l - 1], arr[l] - nums[i]);
            }
        }
        return res;
    }

    public void getArr() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 5000; i++) {
            if (chk(i))
                list.add(i);
        }
        arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public boolean chk(int num) {
        int l = 1;
        int r = 1 << (31 - Integer.numberOfLeadingZeros(num));
        while (l < r) {
            if (!chk(num & l, num & r))
                return false;
            l <<= 1;
            r >>= 1;
        }
        return true;
    }

    public boolean chk(int a, int b) {
        return a == b || (a != 0 && b != 0);
    }
}
