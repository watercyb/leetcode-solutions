/*
 * Problem: 380. Insert Delete GetRandom O(1)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Language: java
 * Date: 2026-04-03
 */

class RandomizedSet {
    int[] arr = new int[200001];
    int idx = 0;
    HashMap<Integer, Integer> HM = new HashMap<>();
    Random rand = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (HM.containsKey(val))
            return false;
        HM.put(val, idx);
        arr[idx++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!HM.containsKey(val))
            return false;
        int index = HM.get(val);
        HM.remove(val);
        if (index == idx - 1) {
            idx--;
        } else {
            arr[index] = arr[--idx];
            HM.put(arr[index], index);
        }
        return true;
    }

    public int getRandom() {
        int i = rand.nextInt(idx);
        return arr[i];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
