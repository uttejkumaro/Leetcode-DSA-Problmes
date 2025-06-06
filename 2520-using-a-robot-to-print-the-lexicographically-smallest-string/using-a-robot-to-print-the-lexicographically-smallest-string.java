class Solution {
    public String robotWithString(String s) {
        int n=s.length();
       StringBuilder sb=new  StringBuilder();
       int next[]=new int[n];
       next[n-1]=s.charAt(n-1);
       for(int i=n-2;i>=0;i--){
            next[i]=Math.min(next[i+1],s.charAt(i));
       }
       Stack<Character>st=new Stack<>();
       for(int i=0;i<n;i++){
        st.push(s.charAt(i));
        while(!st.isEmpty() && (i==n-1|| st.peek()<=next[i+1])){
            sb.append(st.pop());
        }
       }
       return sb.toString();
    }
}