class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        helper(result,"",0,0,n);
        return result;
    }
    void helper(List<String>result,String current,int open,int  close,int max){
        if(current.length()==2*max){
            result.add(current);
            return;
        }
         if (open < max) {
           helper(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            helper(result, current + ")", open, close + 1, max);
        }
    }      
}