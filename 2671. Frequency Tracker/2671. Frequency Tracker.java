/*
 * Problem: 2671. Frequency Tracker
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/frequency-tracker/
 * Language: java
 * Date: 2026-04-29
 */

class FrequencyTracker {
    HashMap<Integer, Integer> f = new HashMap<>();
    HashMap<Integer, Integer> numbers = new HashMap<>();

    public FrequencyTracker() {

    }

    public void add(int number) {
        int count = numbers.getOrDefault(number, 0);
        numbers.put(number, count + 1);
        if (count > 0)
            f.put(count, f.getOrDefault(count, 0) - 1);
        f.put(count + 1, f.getOrDefault(count + 1, 0) + 1);
    }

    public void deleteOne(int number) {
        int count = numbers.getOrDefault(number, 0);
        if (count == 0)
            return;
        numbers.put(number, count - 1);
        f.put(count, f.getOrDefault(count, 0) - 1);
        if (count > 0)
            f.put(count - 1, f.getOrDefault(count - 1, 0) + 1);
    }

    public boolean hasFrequency(int frequency) {
        return f.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
