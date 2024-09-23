class Solution {
    public int minExtraChar(String s, String[] dictionary) {
    int n=s.length();
    Set<String>set=new HashSet<>();
    for(String st:dictionary){
        set.add(st);
    }
    int dp[]=new int[n+1];
    for(int i=0;i<=n;i++){
        dp[i]=i;
    }
    for(int i=0;i<=n;i++){
        for(int j=0;j<i;j++){
            String str=s.substring(j,i);
            if(set.contains(str)){
                dp[i]=Math.min(dp[i],dp[j]);
            }
            else{
                dp[i]=Math.min(dp[i],dp[j]+i-j);
            }
        }
    }
    return dp[n];

        
    }
}