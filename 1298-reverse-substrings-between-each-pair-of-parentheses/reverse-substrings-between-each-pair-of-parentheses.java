/* class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // pop '('
                }
                for (char ch : sb.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString(); // Reverse result to get the correct order
    }
}
*/
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(c);
            }
        }
        
        return current.toString();
    }
}
