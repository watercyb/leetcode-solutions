/*
 * Problem: 3422. Minimum Operations to Make Subarray Elements Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-subarray-elements-equal/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minOperations(int[] nums, int k) {
        lefts.add(new int[] { Integer.MIN_VALUE / 2, Integer.MAX_VALUE });
        rights.add(new int[] { Integer.MAX_VALUE / 2, Integer.MAX_VALUE });
        isLefts = new boolean[nums.length];
        for (int i = 0; i < k; i++) {
            add(i, nums[i]);
            even();
        }
        long res = Math.min((long) lefts.peek()[0] * count + sum, (long) rights.peek()[0] * count + sum);
        for (int i = k; i < nums.length; i++) {
            if (isLefts[i - k]) {
                count--;
                sum += nums[i - k];
            } else {
                count++;
                sum -= nums[i - k];
            }
            even();
            trim(i - k);
            add(i, nums[i]);
            even();
            res = Math.min(res,
                    Math.min((long) lefts.peek()[0] * count + sum, (long) rights.peek()[0] * count + sum));
        }
        return res;
    }

    PriorityQueue<int[]> lefts = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    PriorityQueue<int[]> rights = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    boolean[] isLefts;
    int count = 0;
    long sum = 0;

    public void even() {
        if (count < 0) {
            int[] pair = rights.poll();
            lefts.offer(pair);
            isLefts[pair[1]] = true;
            count += 2;
            sum -= 2 * pair[0];
        } else if (count > 1) {
            int[] pair = lefts.poll();
            rights.offer(pair);
            isLefts[pair[1]] = false;
            count -= 2;
            sum += 2 * pair[0];
        }
    }

    public void trim(int i) {
        while (lefts.peek()[1] <= i) {
            lefts.poll();
        }
        while (rights.peek()[1] <= i) {
            rights.poll();
        }
    }

    public void add(int i, int num) {
        if (num <= lefts.peek()[0]) {
            lefts.offer(new int[] { num, i });
            count++;
            isLefts[i] = true;
            sum -= num;
        } else {
            rights.offer(new int[] { num, i });
            count--;
            isLefts[i] = false;
            sum += num;
        }
    }
}
