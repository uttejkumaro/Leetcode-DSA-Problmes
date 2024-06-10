

class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char i : ch) {
            if (i == '{' || i == '[' || i == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top == '[' && i != ']') {
                    return false;
                } else if (top == '(' && i != ')') {
                    return false;
                } else if (top == '{' && i != '}') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
