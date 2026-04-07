class MinStack {

    private Stack<Integer> value;
    private Stack<Integer> minValue;

    public MinStack() {
        this.value = new Stack<>();
        this.minValue = new Stack<>();
    }
    
    public void push(int val) {
        value.push(val);
        if (minValue.isEmpty() || val <= minValue.peek()) {
            minValue.push(val);
        }
    }
    
    public void pop() {
       if (value.pop().equals(minValue.peek())) {
            minValue.pop();
        }
    }
    
    public int top() {
        return value.peek();
    }
    
    public int getMin() {
        return minValue.peek();
    }
}
