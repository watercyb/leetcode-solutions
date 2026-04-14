/*
 * Problem: 1172. Dinner Plate Stacks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/dinner-plate-stacks/
 * Language: java
 * Date: 2026-04-14
 */

class DinnerPlates {
    List<Deque<Integer>> Dqs = new ArrayList<>();
    PriorityQueue<Integer> PQ = new PriorityQueue<>();
    int capacity;
    int n = 0;
    int lastIdx = -1;
    int size = 0;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        n++;
        if (PQ.isEmpty()) {
            Dqs.add(new ArrayDeque<>());
            PQ.offer(size++);
        }
        int idx = PQ.peek();
        if (idx > lastIdx)
            lastIdx = idx;
        Deque<Integer> Dq = Dqs.get(idx);
        Dq.offerFirst(val);
        if (Dq.size() == capacity)
            PQ.poll();
    }

    public int pop() {
        if (n == 0)
            return -1;
        n--;
        Deque<Integer> Dq = Dqs.get(lastIdx);
        while (Dq.isEmpty()) {
            Dq = Dqs.get(--lastIdx);
        }
        if (Dq.size() == capacity)
            PQ.offer(lastIdx);
        return Dq.pollFirst();
    }

    public int popAtStack(int index) {
        Deque<Integer> Dq;
        if (n == 0 || index > lastIdx || (Dq = Dqs.get(index)).isEmpty())
            return -1;
        n--;
        if (Dq.size() == capacity)
            PQ.offer(index);
        return Dq.pollFirst();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
