class Solution {
    private  boolean isNum(String expression){
        for(char c:expression.toCharArray()){
            if(!Character.isDigit(c)) return false;
            
        }
        return true;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>res=new ArrayList<>();
        if(isNum(expression)){
            res.add(Integer.parseInt(expression));
            return res;
        }
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c=='+' || c=='-'|| c=='*'|| c=='/'){
             List<Integer>left=diffWaysToCompute(expression.substring(0,i));
            List<Integer>right=diffWaysToCompute(expression.substring(i+1));
            for(int l:left){
                for(int r:right){
                    if(c=='+') res.add(l+r);
                    else if(c=='-') res.add(l-r);
                    else if(c=='*') res.add(l*r);
                    else if(c=='/') res.add(l/r);
                }
            }
            }


        }
        return res;
       
        
    }
}