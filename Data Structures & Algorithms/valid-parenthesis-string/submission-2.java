class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParenthesis = new Stack<>();
        Stack<Integer> starPare = new Stack<>();

        int index=0;
        while(index<s.length()) {
            if(s.charAt(index)=='(') {
                leftParenthesis.push(index);
            }
            else if (s.charAt(index)==')') {
                if(!leftParenthesis.isEmpty()) {
                    leftParenthesis.pop();
                } else if(!starPare.isEmpty()){
                   starPare.pop();
                } else {
                    return false;
                }
            } else {
                starPare.push(index);
            }
            index++;
        }
        while(!leftParenthesis.isEmpty() && !starPare.isEmpty()) {
            if(leftParenthesis.peek()<starPare.peek()) {
                leftParenthesis.pop();
                starPare.pop();
            } else {
                return false;
            } 
        }
        return leftParenthesis.isEmpty();
    }
}
