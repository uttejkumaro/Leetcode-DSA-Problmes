class Solution {

    List<String> ans;

    private void solve(String s , List<String> dict,String str){
        if(s.length()<=0){
            ans.add(str.substring(1,str.length()));
        }
        for(int i = 0; i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))){
                String temp = str+" "+s.substring(0,i+1);           
                solve(s.substring(i+1,s.length()),dict,temp);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        solve(s,wordDict,"");
        return ans;
    }
}