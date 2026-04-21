/*
 * Problem: 1865. Finding Pairs With a Certain Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
 * Language: java
 * Date: 2026-04-21
 */

class FindSumPairs {
    HashMap<Integer, Integer> HM = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int num : nums2) {
            HM.put(num, HM.getOrDefault(num, 0) + 1);
        }
        this.nums1 = nums1;
        Arrays.sort(this.nums1);
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        HM.put(nums2[index], HM.get(nums2[index]) - 1);
        nums2[index] += val;
        HM.put(nums2[index], HM.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int i = 0; i < nums1.length && nums1[i] < tot; i++) {
            res += HM.getOrDefault(tot - nums1[i], 0);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
