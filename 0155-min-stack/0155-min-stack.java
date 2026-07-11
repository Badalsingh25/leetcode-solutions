class MinStack {

    Stack<Integer> stack= new Stack(); // Stores All Elements
    Stack<Integer> minStack= new Stack(); // Stores only minimum elements

    public MinStack() {
        // stack = new Stack();
        // minStack = new Stack();
        // stack = new Stack<>();
        // minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);

        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */