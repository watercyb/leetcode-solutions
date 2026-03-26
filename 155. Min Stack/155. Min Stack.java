/*
 * Problem: 155. Min Stack
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/min-stack/
 * Language: java
 * Date: 2026-03-26
 */

class MinStack {
    Stack<Integer> stack, min_vals;
    public MinStack() { 
        stack = new Stack<>(); 
        min_vals = new Stack<>();
    }
    
    public void push(int val) {
        if(min_vals.isEmpty() || val <= min_vals.peek()){
            min_vals.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(min_vals.peek())){
            min_vals.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
