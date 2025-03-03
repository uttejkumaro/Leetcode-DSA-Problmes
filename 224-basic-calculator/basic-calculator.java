class Solution {
    public int calculate(String s) {
    int res=0;
    int sign=1; //sign 1 for + and sign -1 for -1;
    Stack<int []>st=new Stack<>();
   int i=0;
    while(i<s.length()){
        char c=s.charAt(i);
            int num=0;
        if(Character.isDigit(c)){
            while(i<s.length() && Character.isDigit(s.charAt(i)) ){
                num=num*10+(s.charAt(i)-'0');
                i++;
            }
            res+=sign*num;
            continue;
        }
        else if(c=='+'){
            sign=1;
        }
        else if(c=='-'){
            sign=-1;
        }
        else if(c=='('){
            st.push(new int[]{res,sign});

            res=0;
            sign=1;
        }
        else if(c==')'){
            int []prev=st.pop();
            res=prev[0]+prev[1]*res;            
        }
        i++;
    }
    return res;    
    }
}