class Solution {
    static Map<Character,Character> openToCloseMap = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    static Map<Character,Character> closeToOpen = new HashMap<>() {{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};

    public boolean isValid(String s) {
        int index = 0;
        Stack<Character> st = new Stack<>();
        while(index<s.length()) {
            char currChar = s.charAt(index);
            if (openToCloseMap.containsKey(currChar)){
                st.push(currChar);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek()!=closeToOpen.get(currChar)) {
                    return false;
                } else {
                    st.pop();
                }
            }
            index++;
        }
        return st.isEmpty();
    }
}
