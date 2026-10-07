class CustomStack {

    int[] stack;
    int top;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if(top + 1 < maxSize){
            stack[++top] = x;
        }
    }

    public int pop() {
       if(top == -1) return -1;
       return stack[top--];
    }

    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, top + 1); i++){
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */