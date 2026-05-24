class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = new ArrayList<>() {
                {
                    add("+");
                    add("/");
                    add("*");
                    add("-");
                }
        };
        Stack<Integer> stackCal = new Stack<>();
        for (String token:tokens) {
            if (operators.contains(token)) {
                int y = stackCal.pop();
                int x = stackCal.pop();
                stackCal.push(eval(token, x, y));
            }
            else {
                stackCal.push(Integer.parseInt(token));
            }
        }
        return stackCal.pop();
    }

    private int eval(String operator, int x, int y) {
        if (operator.equals("+")) {
            return x+y;
        }
        if (operator.equals("*")) {
            return x*y;
        }
        if (operator.equals("/")) {
            return x/y;
        }
        if (operator.equals("-")) {
            return x-y;
        }
        return -1;
    }

}
