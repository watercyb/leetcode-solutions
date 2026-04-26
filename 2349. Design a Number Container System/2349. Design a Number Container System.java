/*
 * Problem: 2349. Design a Number Container System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-number-container-system/
 * Language: java
 * Date: 2026-04-26
 */

class NumberContainers {
    HashMap<Integer, PriorityQueue<Integer>> HM = new HashMap<>();
    HashMap<Integer, Integer> HM1 = new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        if (HM1.getOrDefault(index, -1) == number)
            return;
        if (!HM.containsKey(number)) {
            PriorityQueue<Integer> PQ = new PriorityQueue<>();
            PQ.offer(index);
            HM.put(number, PQ);
        } else {
            PriorityQueue<Integer> PQ = HM.get(number);
            PQ.offer(index);
        }
        if (HM1.containsKey(index)) {
            int n = HM1.get(index);
            HM.get(n).remove(index);
        }
        HM1.put(index, number);
    }

    public int find(int number) {
        if (!HM.containsKey(number))
            return -1;
        PriorityQueue<Integer> PQ = HM.get(number);
        if (!PQ.isEmpty())
            return PQ.peek();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
