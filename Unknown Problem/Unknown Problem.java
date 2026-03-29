/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-phone-directory/?envType=weekly-question&envId=2026-03-29
 * Language: java
 * Date: 2026-03-29
 */

class PhoneDirectory {
    boolean[] used;
    int max = 0;
    int[] arr = new int[20000];
    int l = 0;
    int r = 0;

    public PhoneDirectory(int maxNumbers) {
        used = new boolean[maxNumbers];
    }

    public int get() {
        if (l < r) {
            used[arr[l]] = true;
            return arr[l++];
        } else if (max < used.length) {
            used[max] = true;
            return max++;
        }
        return -1;
    }

    public boolean check(int number) {
        return !used[number];
    }

    public void release(int number) {
        if (!used[number])
            return;
        used[number] = false;
        arr[r++] = number;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
