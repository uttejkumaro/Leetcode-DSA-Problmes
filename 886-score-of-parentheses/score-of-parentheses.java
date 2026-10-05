class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        st.push(0);
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')st.push(0);
            else{

             int top=st.pop();
            int score=(top==0)?1:2*top;
            st.push(st.pop()+score);
            }
        }
        return st.pop();
    }
}