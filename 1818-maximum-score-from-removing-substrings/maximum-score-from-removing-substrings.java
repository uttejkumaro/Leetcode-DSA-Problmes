class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st=new Stack<>();
        int maxp=0;
        if(x>y){
            maxp+=x(s,st,x);
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            s=sb.reverse().toString();
            maxp+=y(s,st,y);
        } 
        else{
            maxp+=y(s,st,y);
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            s=sb.reverse().toString();
            maxp+=x(s,st,x);
        }
        return maxp;
    }
    public int x(String s,Stack<Character> st,int x){
        int maxp=0;
        for(char ch:s.toCharArray()){
                if(!st.isEmpty() && st.peek()=='a' && ch=='b'){
                    st.pop();
                    maxp+=x;
                }
                else{
                    st.push(ch);
                }
            }
        return maxp;
    }
    public int y(String s,Stack<Character> st,int y){
        int maxp=0;
        for(char ch:s.toCharArray()){
                if(!st.isEmpty() && st.peek()=='b' && ch=='a'){
                    st.pop();
                    maxp+=y;
                }
                else{
                    st.push(ch);
                }
            }
        return maxp;
    }
}