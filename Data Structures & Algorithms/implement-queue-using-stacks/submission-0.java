class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack= new Stack<>();
        
    }
    
    public void push(int x) {
        Stack<Integer> st = new Stack<>();
        while(!stack.isEmpty()) {
            st.push(stack.pop());
        }
        st.push(x);
        while(!st.isEmpty()) {
            stack.push(st.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
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