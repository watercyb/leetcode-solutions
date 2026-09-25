/*
 * Problem: 4059. Lexicographically Largest Power Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-largest-power-array/
 * Language: java
 * Date: 2026-09-25
 */

class Solution {
    public int[] largestPower(int[] nums) {
        int[] ranks = new int[nums.length];
        int[] res = new int[15];
        for (int i = 14; i >= 0; i--) {
            int len = sort(nums, ranks, i);
            res[14 - i] = len;
        }
        return res;
    }

    public int sort(int[] nums, int[] ranks, int i) {
        int hasGap = 0;
        int mask = 1 << i;
        int prv = 0;
        int k = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            if (ranks[j] != prv) {
                k = j;
                if (hasGap != 0)
                    break;
                prv = ranks[j];
            }
            if ((nums[j] & mask) != 0) {
                if (hasGap == 0 || hasGap == ranks[j]) {
                    ranks[j] += mask;
                    swap(nums, ranks, k, j);
                    k++;
                    len = k;
                }
            } else if (ranks[j] > 0 && hasGap == 0) {
                hasGap = ranks[j];
            }
        }
        return len;
    }

    public void swap(int[] nums, int[] ranks, int i, int j) {
        if (i == j)
            return;
        int tempNum = nums[i];
        nums[i] = nums[j];
        nums[j] = tempNum;
        int tempRank = ranks[i];
        ranks[i] = ranks[j];
        ranks[j] = tempRank;
    }
}

class Node {
    int num;
    long rank = 0;

    public Node(int num) {
        this.num = num;
    }
}
