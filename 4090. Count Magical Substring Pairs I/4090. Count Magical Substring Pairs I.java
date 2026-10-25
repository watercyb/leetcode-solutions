/*
 * Problem: 4090. Count Magical Substring Pairs I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-magical-substring-pairs-i/
 * Language: java
 * Date: 2026-10-25
 */

class Solution {
    public int countMagicalPairs(String s) {
        char[] chrs = s.toCharArray();
        int[] arr = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            arr[i] = chrs[i] - 'a';
        }
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            int count = get(arr, i);
            if (count == 0)
                break;
            res += count;
        }
        return res;
    }

    public int get(int[] nums, int n) {
        int[] lefts = getLefts(nums, n);
        int[] rights = getRights(nums, n);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res += lefts[i] * rights[i + 1];
        }
        return res;
    }

    public int[] getLefts(int[] nums, int n) {
        int len = nums.length;
        int[] result = new int[len];

        int[] freqN = new int[26];
        int[] freqM = new int[26];

        int leftN = 0, leftM = 0;
        int distinctN = 0, distinctM = 0;

        for (int right = 0; right < len; right++) {
            int x = nums[right];

            if (freqN[x]++ == 0)
                distinctN++;
            if (freqM[x]++ == 0)
                distinctM++;

            while (distinctN > n) {
                if (--freqN[nums[leftN++]] == 0)
                    distinctN--;
            }

            while (distinctM > n - 1) {
                if (--freqM[nums[leftM++]] == 0)
                    distinctM--;
            }

            result[right] = leftM - leftN;
        }

        return result;
    }

    public int[] getRights(int[] nums, int n) {
        int len = nums.length;
        int[] result = new int[len];

        int[] freqN = new int[26];
        int[] freqM = new int[26];

        int leftN = len - 1, leftM = len - 1;
        int distinctN = 0, distinctM = 0;

        for (int left = len - 1; left >= 0; left--) {
            int x = nums[left];

            if (freqN[x]++ == 0)
                distinctN++;
            if (freqM[x]++ == 0)
                distinctM++;

            while (distinctN > n) {
                if (--freqN[nums[leftN--]] == 0)
                    distinctN--;
            }

            while (distinctM > n - 1) {
                if (--freqM[nums[leftM--]] == 0)
                    distinctM--;
            }

            result[left] = leftN - leftM;
        }

        return result;
    }
}
