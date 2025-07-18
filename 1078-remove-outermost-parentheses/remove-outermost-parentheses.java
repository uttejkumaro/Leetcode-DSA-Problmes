class Solution {
    
    // Optional static block to warm up the JVM (not needed in production)
    static {
        for (int i = 0; i < 500; i++) {
            removeOuterParentheses(""); // JVM JIT warm-up
        }
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder result=new StringBuilder();
        int balance=0;
       for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c); 
                }
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
        
    }
}