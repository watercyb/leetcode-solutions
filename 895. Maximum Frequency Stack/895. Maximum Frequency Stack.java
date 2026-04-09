/*
 * Problem: 895. Maximum Frequency Stack
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-frequency-stack/
 * Language: java
 * Date: 2026-04-09
 */

class FreqStack {
    HashMap<Integer, Integer> HM = new HashMap<>();
    List<List<Integer>> Li = new ArrayList<>();

    public FreqStack() {

    }

    public void push(int val) {
        int count = 0;
        if (HM.containsKey(val)) {
            count = HM.get(val);
            count++;
        }
        HM.put(val, count);
        if (count == Li.size()) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(val);
            Li.add(tmp);
        } else {
            Li.get(count).add(val);
        }
    }

    public int pop() {
        int size=Li.size() - 1;
        List<Integer> tmp = Li.get(size);
        int val = tmp.get(tmp.size() - 1);
        HM.put(val, HM.get(val) - 1);
        if (tmp.size() == 1) {
            Li.remove(size);
        } else {
            tmp.remove(tmp.size() - 1);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
