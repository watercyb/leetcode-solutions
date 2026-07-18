/*
 * Problem: 3850. Count Sequences to K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-sequences-to-k/
 * Language: java
 * Date: 2026-07-18
 */

class Solution {
    public int countSequences(int[] nums, long k) {
        int base = (1 << 17) + (1 << 11) + (1 << 5);
        int target = base;
        while (k % 2 == 0) {
            k /= 2;
            target++;
        }
        while (k % 3 == 0) {
            k /= 3;
            target += 1 << 6;
        }
        while (k % 5 == 0) {
            k /= 5;
            target += 1 << 12;
        }
        if (k != 1)
            return 0;
        HashMap<Integer, Integer> HM = new HashMap<>();
        HM.put(base, 1);
        for (int num : nums) {
            HashMap<Integer, Integer> HMNext = new HashMap<>();
            int h = getH(num);
            for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                HMNext.put(key, HMNext.getOrDefault(key, 0) + val);
                HMNext.put(key + h, HMNext.getOrDefault(key + h, 0) + val);
                HMNext.put(key - h, HMNext.getOrDefault(key - h, 0) + val);
            }
            HM = HMNext;
        }
        return HM.getOrDefault(target, 0);
    }

    public int getH(int num) {
        int res = 0;
        while (num % 2 == 0) {
            num /= 2;
            res++;
        }
        while (num % 3 == 0) {
            num /= 3;
            res += 1 << 6;
        }
        while (num % 5 == 0) {
            num /= 3;
            res += 1 << 12;
        }
        return res;
    }
}
