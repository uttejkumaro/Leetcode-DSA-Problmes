// class Solution{

//     public int minAddToMakeValid(String s){
//         int openBrackets = 0;
//         int minAdds= 0;
//         for(char c:s.toCharArray()){
//             if(c == '(') {
//                 openBrackets++;
//             }else {
//                 if(openBrackets>0){
//                     openBrackets--;
//                 }
//                 else {
//                     minAdds++;
//                 }
//             }
//         }

//         return minAdds+openBrackets;
//     }
// }
class Solution{
    public int minAddToMakeValid(String s){
        Stack<Character>st=new Stack<>();
        for (char c:s.toCharArray()){
            
            if(!st.isEmpty() && (c==')' && st.peek()=='(')){
                st.pop();
            }
            else{
                st.push(c);
            }

        }
        return st.size();
    }
}

        