/*
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-pairs-after-increment/
 * Language: java
 * Date: 2026-05-28
 */

class Solution {
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int num : nums1) {
            HM.put(num, HM.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        int max = 0;
        for (int[] query : queries) {
            if (query[0] == 2) {
                count++;
                max = Math.max(max, query[1]);
            }
        }
        int[] res = new int[count];
        if (count == 0)
            return res;
        int len = 1000;
        Node[] nodes = new Node[(nums2.length + len - 1) / len];
        for (int i = 0; i < nums2.length; i += len) {
            nodes[i / len] = new Node(nums2, i, Math.min(i + len - 1, nums2.length - 1), max);
        }
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                int left = query[1] / len;
                int right = query[2] / len;
                for (int i = left; i <= right; i++) {
                    nodes[i].update(query[1], query[2], query[3]);
                }
            } else {
                int sum = 0;
                for (Map.Entry<Integer, Integer> e : HM.entrySet()) {
                    int num = e.getKey();
                    int val = e.getValue();
                    if (num >= query[1])
                        continue;
                    for (Node node : nodes) {
                        sum += node.get(query[1] - num) * val;
                    }
                }
                res[idx++] = sum;
            }
        }
        return res;
    }
}

class Node {
    int[] nums;
    HashMap<Integer, Integer> HM = new HashMap<>();
    int offset = 0;
    int l;
    int r;
    int max;

    public Node(int[] arr, int l, int r, int max) {
        this.l = l;
        this.r = r;
        this.max = max;
        nums = new int[r - l + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[l];
            if (nums[i] <= max)
                HM.put(arr[l], HM.getOrDefault(arr[l], 0) + 1);
            l++;
        }
    }

    public void update(int l, int r, int num) {
        if (l <= this.l && r >= this.r) {
            offset += num;
        } else {
            if (offset > max)
                return;
            l = Math.max(l - this.l, 0);
            r = Math.min(r - this.l, nums.length - 1);
            for (int i = l; i <= r; i++) {
                int oldVal = nums[i];
                if (oldVal < max) {
                    int count = HM.get(oldVal) - 1;
                    if (count == 0) {
                        HM.remove(oldVal);
                    } else {
                        HM.put(oldVal, count);
                    }
                }
                nums[i] += num;
                if (nums[i] < max)
                    HM.put(nums[i], HM.getOrDefault(nums[i], 0) + 1);
            }
        }
    }

    public int get(int num) {
        return HM.getOrDefault(num - offset, 0);
    }
}
