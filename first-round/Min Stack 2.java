public class MinStack {
    
    long min;
    Stack<Long> stack;
    /** initialize your data structure here. */
    
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0L);
        }
        else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }
    
    public void pop() {
        long value = stack.pop();
        if (value < 0) min = min - value;
    }
    
    public int top() {
        long value = stack.peek();
        if (value > 0) {
            return (int) (value + min);
        }
        else return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 
 */