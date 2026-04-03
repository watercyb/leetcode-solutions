/*
 * Problem: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * Language: java
 * Date: 2026-04-03
 */

class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> HM = new HashMap<>();
    int[] arr = new int[20001];
    int n = 0;
    Random random = new Random();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {
        HashSet<Integer> HS = HM.getOrDefault(val, new HashSet<>());
        boolean res = HS.size() == 0;
        HS.add(n);
        HM.put(val, HS);
        arr[n] = val;
        n++;
        return res;
    }

    public boolean remove(int val) {
        HashSet<Integer> HS = HM.getOrDefault(val, new HashSet<>());
        if (HS.size() > 0) {
            n--;
            int removedIdx = HS.iterator().next();
            HS.remove(removedIdx);
            if (removedIdx != n) {
                arr[removedIdx] = arr[n];
                HS = HM.get(arr[removedIdx]);
                HS.remove(n);
                HS.add(removedIdx);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        return arr[random.nextInt(n)];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
