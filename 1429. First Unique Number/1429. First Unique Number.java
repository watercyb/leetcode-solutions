/*
 * Problem: 1429. First Unique Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/first-unique-number/
 * Language: java
 * Date: 2026-04-17
 */

class FirstUnique {
    int[] arr;
    int l = 0;
    int r = 0;
    HashSet<Integer> HM = new HashSet<>();
    HashSet<Integer> HM1 = new HashSet<>();

    public FirstUnique(int[] nums) {
        arr = new int[nums.length + 50000];
        for (int num : nums) {
            if (!HM.add(num)) {
                HM1.add(num);
            } else {
                arr[r++] = num;
            }
        }
    }

    public int showFirstUnique() {
        while (r > l && HM1.contains(arr[l])) {
            l++;
        }
        if (r > l)
            return arr[l];
        return -1;
    }

    public void add(int value) {
        if (!HM.add(value)) {
            HM1.add(value);
        } else {
            arr[r++] = value;
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
