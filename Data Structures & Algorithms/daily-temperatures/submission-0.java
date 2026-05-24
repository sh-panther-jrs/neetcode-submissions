class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        output[temperatures.length-1] = 0;
        stack.push(temperatures.length-1);
        int index = temperatures.length-2;
        while(index>=0) {
            while(!stack.isEmpty() 
            && temperatures[stack.peek()]<=temperatures[index]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output[index] =0;
                stack.push(index);
            } else {
                output[index] = stack.peek()-index;
                stack.push(index);
            }
            index--;
        }
        return output;
    }
}
