/*
 * Problem: 4094. Count Frequency Staircase Subarrays I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-frequency-staircase-subarrays-i/
 * Language: java
 * Date: 2026-11-05
 */

class Solution {
    public int countStaircase(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int count = 0;
        int[] newNums = new int[max + 1];
        Arrays.fill(newNums, -1);
        for (int i = 0; i < nums.length; i++) {
            if (newNums[nums[i]] != -1) {
                nums[i] = newNums[nums[i]];
            } else {
                newNums[nums[i]] = count;
                nums[i] = count;
                count++;
            }
        }
        List<Integer>[] pos = new ArrayList[count];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = new ArrayList<>();
        }
        int[] indexesInPos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexesInPos[i] = pos[nums[i]].size();
            pos[nums[i]].add(i);
        }
        int res = 0;
        int[] seens = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = nums.length;
            int size = 0;
            for (int j = i; j < right; j++) {
                int num = nums[j];
                if (seens[num] != i + 1) {
                    seens[num] = i + 1;
                    size++;
                    List<Integer> p = pos[num];
                    if (p.size() - indexesInPos[j] < size)
                        break;
                    left = Math.max(left, p.get(indexesInPos[j] + size - 1));
                    if (indexesInPos[j] + size < p.size())
                        right = Math.min(right, p.get(indexesInPos[j] + size));
                    if (left > right)
                        break;
                    int lim = i + size * (size + 1) / 2 - 1;
                    if (left <= lim && lim < right)
                        res++;
                }
            }
        }
        return res;
    }
}
