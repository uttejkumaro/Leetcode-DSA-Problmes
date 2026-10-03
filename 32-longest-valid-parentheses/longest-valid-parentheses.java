// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer> st = new Stack<>();
//         st.push(-1);
//         int max = 0;

//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 st.push(i);
//             } else {
//                 st.pop();

//                 if (st.isEmpty()) {
//                     st.push(i);
//                 } else {
//                     max = Math.max(max, i - st.peek());
//                 }
//             }
//         }

//         return max;
//     }
// }

class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, max = 0;

        // Left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                max = Math.max(max, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;

        // Right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                max = Math.max(max, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return max;
    }
}
