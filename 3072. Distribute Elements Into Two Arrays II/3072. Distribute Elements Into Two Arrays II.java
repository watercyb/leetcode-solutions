/*
 * Problem: 3072. Distribute Elements Into Two Arrays II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distribute-elements-into-two-arrays-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int[] resultArray(int[] nums) {
        BIT bit1 = new BIT(nums.length);
        BIT bit2 = new BIT(nums.length);
        int[] numsSort = nums.clone();
        Arrays.sort(numsSort);
        bit1.insert(Arrays.binarySearch(numsSort, nums[0]), nums[0]);
        bit2.insert(Arrays.binarySearch(numsSort, nums[1]), nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int idx = Arrays.binarySearch(numsSort, nums[i]);
            int a = bit1.get(idx);
            int b = bit2.get(idx);
            if (a > b || (a == b && bit1.idx <= bit2.idx)) {
                bit1.insert(idx, nums[i]);
            } else {
                bit2.insert(idx, nums[i]);
            }
        }
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < bit1.idx; i++) {
            res[idx++] = bit1.arr[i];
        }
        for (int i = 0; i < bit2.idx; i++) {
            res[idx++] = bit2.arr[i];
        }
        return res;
    }
}

class BIT {
    int[] BIT;
    int[] arr;
    int idx = 0;

    public BIT(int n) {
        BIT = new int[n + 1];
        arr = new int[n + 1];
    }

    public void insert(int i, int num) {
        arr[idx++] = num;
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return idx - res;
    }
}
