/*
 * Problem: 949. Largest Time for Given Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-time-for-given-digits/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[] counts = new int[10];
        for (int num : arr) {
            counts[num]++;
        }
        char[] res = new char[5];
        res[2] = ':';
        if (digit1(counts, res))
           return new String(res);
        return "";
    }

    public boolean digit1(int[] counts, char[] res) {
        for (int i = 2; i >= 0; i--) {
            if (counts[i] != 0) {
                counts[i]--;
                res[0] = (char) (i + '0');
                if (digit2(counts, res))
                    return true;
                counts[i]++;
            }
        }
        return false;
    }

    public boolean digit2(int[] counts, char[] res) {
        for (int i = res[0] == '2' ? 3 : 9; i >= 0; i--) {
            if (counts[i] != 0) {
                counts[i]--;
                res[1] = (char) (i + '0');
                if (digit3(counts, res))
                    return true;
                counts[i]++;
            }
        }
        return false;
    }

    public boolean digit3(int[] counts, char[] res) {
        for (int i = 5; i >= 0; i--) {
            if (counts[i] != 0) {
                counts[i]--;
                res[3] = (char) (i + '0');
                if (digit4(counts, res))
                    return true;
                counts[i]++;
            }
        }
        return false;
    }

    public boolean digit4(int[] counts, char[] res) {
        for (int i = 9; i >= 0; i--) {
            if (counts[i] != 0) {
                res[4] = (char) (i + '0');
                return true;
            }
        }
        return false;
    }
}
