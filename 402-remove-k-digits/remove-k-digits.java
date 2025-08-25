class Solution {
    public String removeKdigits(String num, int k) {
            int n=num.length();
            Stack<Character>st=new Stack<>();
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                    st.pop();
                    k--;
                }
                st.push(num.charAt(i));
            }
            while(k>0 && !st.isEmpty()){
                st.pop();
                k--;
            }
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            sb.reverse();
            while(sb.length()>0 && sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
            }
            return sb.length()==0?"0":sb.toString();            
    }
}
/**
Step-by-step complexity:

Outer loop runs n times. ✅

Inner while loop – looks dangerous, but here’s the catch:

Every pop() reduces either k or removes an element pushed before.

Each element is pushed at most once and popped at most once.

So total number of pop() operations across the entire loop is ≤ n (or ≤ initial k, whichever smaller). */