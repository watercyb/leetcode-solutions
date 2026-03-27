/*
 * Problem: 225. Implement Stack using Queues
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/implement-stack-using-queues/
 * Language: java
 * Date: 2026-03-27
 */

class MyStack {
    Queue<Integer> Qu1;
    Queue<Integer> Qu2;

    public MyStack() {
        Qu1=new LinkedList<Integer>();
        Qu2=new LinkedList<Integer>();
    }
    
    public void push(int x) {
        int n=Qu1.size();
        for (int i=0;i<n;i++) {
            Qu2.add(Qu1.poll());
        }
        Qu1.add(x);
        for (int i=0;i<n;i++) {
            Qu1.add(Qu2.poll());
        }

    }
    
    public int pop() {
        return Qu1.poll();
    }
    
    public int top() {
        return Qu1.peek();
    }
    
    public boolean empty() {
        return Qu1.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
