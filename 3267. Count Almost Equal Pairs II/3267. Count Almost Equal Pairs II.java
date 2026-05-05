/*
 * Problem: 3267. Count Almost Equal Pairs II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-almost-equal-pairs-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) {
            HS.clear();
            char[] chrs = String.valueOf(num).toCharArray();
            int[] arr = new int[chrs.length];
            for (int i = 0; i < chrs.length; i++) {
                arr[i] = chrs[i] - '0';
            }
            chk(arr);
            swap1(arr);
            HM.put(num, HM.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    HashMap<Integer, Integer> HM = new HashMap<>();
    int res = 0;
    HashSet<Integer> HS = new HashSet<>();

    public void swap1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                chk(arr);
                swap2(arr, i + 1);
                swap(arr, i, j);
            }
        }
    }

    public void swap2(int[] arr, int i) {
        while (i < arr.length - 1) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                chk(arr);
                swap(arr, i, j);
            }
            i++;
        }
    }

    public void chk(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        if (HS.add(num))
            res += HM.getOrDefault(num, 0);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
