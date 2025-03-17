/*
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
*/
class Solution {
   boolean dp[][];
   void build(String s){
    int n=s.length();
    dp=new boolean[n][n];

    for(int i=0;i<n;i++){
        dp[i][i]=true;
    }
    for(int len=2;len<=n;len++){
        for(int start=0;len+start-1<n;start++){
            int end=start+len-1;
            if(s.charAt(start)==s.charAt(end)){
                if(len==2||dp[start+1][end-1]){
                    dp[start][end]=true;

                }
            }
        }
    }

   }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>curr=new ArrayList<>();
        build(s);
        helper(res,curr,0, s);
        return res;
    }
    void helper(List<List<String>>res,List<String>curr,int idx,String s){
        if(idx==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(dp[idx][i]){
                curr.add(s.substring(idx,i+1));
                helper(res,curr,i+1,s);
                curr.remove(curr.size()-1);

            }

        }
    }
}