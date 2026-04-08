/*
 * Problem: 703. Kth Largest Element in a Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Language: java
 * Date: 2026-04-08
 */

class KthLargest {
    int[] counts = new int[20001];
    int min = 0;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            counts[num + 10000]++;
            min = Math.min(num, min);
        }
        if (min != Integer.MAX_VALUE) {
            min += 10000;
        }
        if (k > nums.length) {
            this.k = 1;
        } else {
            for (int i = 0; i < nums.length - k; i++) {
                counts[min]--;
                while (counts[min] == 0) {
                    min++;
                }
            }
            this.k = 0;
        }
        this.min = min;
    }

    public int add(int val) {
        val += 10000;
        if (k == 1) {
            k--;
            counts[val]++;
            min = Math.min(val, min);
        } else {
            if (val > min) {
                counts[val]++;
                counts[min]--;
                while (counts[min] == 0) {
                    min++;
                }
            }
        }
        return min - 10000;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
