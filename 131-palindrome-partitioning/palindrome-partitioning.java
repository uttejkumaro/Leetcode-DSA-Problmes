class Solution {
    boolean isPali(int idx,int i,String s){
        while(idx<=i){

        if(s.charAt(idx++)!=s.charAt(i--)) return false;
        }
        return true;

    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>curr=new ArrayList<>();
        helper(res,curr,0, s);
        return res;
    }
    void helper( List<List<String>>res,List<String>curr,int idx,String s){
        if(idx==s.length()) res.add(new ArrayList<>(curr));
        for(int i=idx;i<s.length();i++){
            if(isPali(idx,i,s)){
                curr.add(s.substring(idx,i+1));
                helper(res,curr,i+1,s);
                curr.remove(curr.size()-1);

            }
        }
    }
}