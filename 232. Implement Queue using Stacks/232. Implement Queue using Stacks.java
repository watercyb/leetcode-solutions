/*
 * Problem: 232. Implement Queue using Stacks
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * Language: java
 * Date: 2026-03-28
 */

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
         stack1=new Stack<Integer>();
         stack2=new Stack<Integer>();
    }
    
    public void push(int x) {
        int n=stack1.size();
        for (int i=0;i<n;i++) {
            stack2.add(stack1.pop());
        }
        stack1.add(x);
        for (int i=0;i<n;i++) {
            stack1.add(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.empty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
