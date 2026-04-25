/*
 * Problem: 2261. K Divisible Elements Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-divisible-elements-subarrays/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Integer>[] listsTemp = new ArrayList[201];
        for (int i = 0; i < nums.length; i++) {
            if (listsTemp[nums[i]] == null) {
                listsTemp[nums[i]] = new ArrayList<>();
                listsTemp[nums[i]].add(i);
                lists.add(listsTemp[nums[i]]);
                int count = nums[i] % p == 0 ? k - 1 : k;
                counts.add(count);
            } else {
                listsTemp[nums[i]].add(i);
            }
        }
        int res = 0;
        while (!lists.isEmpty()) {
            res += lists.size();
            List<List<Integer>> listsNext = new ArrayList<>();
            List<Integer> countsNext = new ArrayList<>();
            for (int i = 0; i < lists.size(); i++) {
                insert(lists.get(i), counts.get(i), listsNext, countsNext, nums, p);
            }
            lists = listsNext;
            counts = countsNext;
        }
        return res;
    }

    public void insert(List<Integer> list, int count, List<List<Integer>> listsNext, List<Integer> countsNext,
            int[] nums, int p) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int idx : list) {
            idx++;
            if (idx == nums.length)
                continue;
            int countNext = count;
            if (nums[idx] % p == 0) {
                if (countNext == 0)
                    continue;
                countNext--;
            }
            if (HM.containsKey(nums[idx])) {
                listsNext.get(HM.get(nums[idx])).add(idx);
            } else {
                HM.put(nums[idx], listsNext.size());
                List<Integer> listTemp = new ArrayList<>();
                listTemp.add(idx);
                listsNext.add(listTemp);
                countsNext.add(countNext);
            }
        }
    }
}
