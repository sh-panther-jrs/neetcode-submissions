class Node {
    int val;
    int minVal;
    public Node(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

class MinStack {
    ArrayList<Node> minStack;
    public MinStack() {
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        int minVal = val;
        if (minStack.size() > 0) {
            Node topStack = minStack.get(minStack.size()-1);
            minVal = Math.min(topStack.minVal, val);
        }
        Node newNode = new Node(val, minVal);
        minStack.add(newNode);
    }
    
    public void pop() {
        if (minStack.size()>0){
            minStack.remove(minStack.size()-1);
        }
    }
    
    public int top() {
        if (minStack.size()>0){
            return minStack.get(minStack.size()-1).val;
        }
        // System.out.println("After top: ");
        return -1;
    }
    
    public int getMin() {
        if (minStack.size()>0) {
            Node topStack = minStack.get(minStack.size()-1);
            return topStack.minVal;
        }
        return -1;
    }
    private void printArr() {
        minStack.forEach(x -> System.out.print(x + ","));
        System.out.println();
    }
}
