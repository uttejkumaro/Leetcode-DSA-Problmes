class Solution {
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        ArrayList<String>result=new ArrayList<>();
        StringBuilder path =new StringBuilder();
        String store[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,n,result,path,store,0);
        return result;
    }
    void  helper(String digits,int n,ArrayList res,StringBuilder path,String store[],int idx){
        if(idx==n){
            if(path.toString().length()>0){
                res.add(path.toString());
            }
                return;
        }
        int currDigit=digits.charAt(idx)-'0';
        for(char c:store[currDigit].toCharArray()){
            path.append(c);
            helper(digits,n,res,path,store,idx+1);
            path.deleteCharAt(path.length()-1);

        }

    }
}