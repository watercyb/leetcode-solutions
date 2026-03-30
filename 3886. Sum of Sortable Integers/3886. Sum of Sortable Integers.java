/*
 * Problem: 3886. Sum of Sortable Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-sortable-integers/
 * Language: java
 * Date: 2026-03-30
 */

class Solution {
    public int sortableIntegers(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max1 = num;
            } else if (num < max2) {
                return 0;
            } else if (num < max1 && num > max2) {
                max2 = num;
            }
        }
        int[] arr = new int[nums.length];
        int idx = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (idx == 0) {
                arr[idx++] = i;
            } else if (nums[i] >= nums[arr[idx - 1]]) {
                arr[idx++] = i;
            } else {
                int id = binarySearch(nums, arr, idx, nums[i]);
                int l = arr[id];
                while (!list.isEmpty()) {
                    int[] pair = list.getLast();
                    if (l <= pair[1]) {
                        l = Math.min(l, pair[0]);
                        list.removeLast();
                    } else {
                        break;
                    }
                }
                list.add(new int[] { l, i });
            }
        }
        if (list.isEmpty()) {
            int res = 0;
            idx = 1;
            while (idx * idx < nums.length) {
                if (nums.length % idx == 0)
                    res += idx + nums.length / idx;
                idx++;
            }
            if (idx * idx == nums.length)
                res += idx;
            return res;
        }
        HashSet<Integer> HS = new HashSet<>();
        for (int[] pair : list) {
            if (!HS.isEmpty()) {
                if (!chk(nums, pair[0], pair[1]))
                    return 0;
                HashSet<Integer> HSNext = new HashSet<>();
                int l = pair[0];
                while (l >= 0 && nums[l] == nums[pair[0]]) {
                    int r = pair[1];
                    while (r < nums.length && (nums[r] == nums[pair[0]] || nums[r] == nums[pair[1]])) {
                        int len = r - l + 1;
                        if (HS.contains(len) && l % len == 0 && nums.length % len == 0)
                            HSNext.add(len);
                        r++;
                    }
                    l--;
                }
                while (l >= 0 && nums[l] == nums[pair[1]]) {
                    int len = pair[1] - l + 1;
                    if (HS.contains(len) && l % len == 0 && nums.length % len == 0)
                        HSNext.add(len);
                    l--;
                }
                if (HSNext.isEmpty())
                    return 0;
                HS = HSNext;
            } else {
                if (!chk(nums, pair[0], pair[1]))
                    return 0;
                int l = pair[0];
                while (l >= 0 && nums[l] == nums[pair[0]]) {
                    int r = pair[1];
                    while (r < nums.length && (nums[r] == nums[pair[0]] || nums[r] == nums[pair[1]])) {
                        int len = r - l + 1;
                        if (l % len == 0 && nums.length % len == 0)
                            HS.add(len);
                        r++;
                    }
                    l--;
                }
                while (l >= 0 && nums[l] == nums[pair[1]]) {
                    int len = pair[1] - l + 1;
                    if (l % len == 0 && nums.length % len == 0)
                        HS.add(len);
                    l--;
                }
                if (HS.isEmpty())
                    return 0;
            }
        }
        int res = 0;
        for (int len : HS) {
            res += len;
        }
        return res;
    }

    public int binarySearch(int[] nums, int[] arr, int idx, int target) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[arr[mid]] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int l, int r) {
        if (nums[l] < nums[r])
            return false;
        while (l < r && nums[l + 1] >= nums[l]) {
            l++;
        }
        l++;
        while (l < r && nums[l + 1] >= nums[l]) {
            l++;
        }
        return l == r;
    }
}
