class Solution{

    public int minAddToMakeValid(String s){
        int openBrackets = 0;
        int minAdds= 0;
        for(char c:s.toCharArray()){
            if(c == '(') {
                openBrackets++;
            }else {
                if(openBrackets>0){
                    openBrackets--;
                }
                else {
                    minAdds++;
                }
            }
        }

        return minAdds+openBrackets;
    }
}