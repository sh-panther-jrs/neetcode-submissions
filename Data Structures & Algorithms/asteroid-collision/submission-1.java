class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num:asteroids) {
            if(stack.isEmpty()) {
                stack.push(num);
            } else {
                if (!isOppositeSign(num, stack.peek())) {
                    stack.push(num);
                } else {
                    if (stack.peek()<0 && num>0) {
                        stack.push(num);
                    } else {
                        while(!stack.isEmpty() 
                        && isOppositeSign(num, stack.peek()) 
                        && Math.abs(stack.peek())<Math.abs(num)) {
                            stack.pop();
                        }
                        if (stack.isEmpty()) {
                            stack.push(num);
                        } else if (!isOppositeSign(num, stack.peek())){
                            stack.push(num);
                        } else if (Math.abs(stack.peek()) == Math.abs(num)) {
                            stack.pop();
                        }
                    }
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
    private boolean isOppositeSign(int a, int b) {
        return (a>0 && b<0) || (b>0 && a<0);
    }
}