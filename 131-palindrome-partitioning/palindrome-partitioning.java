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
// class Solution {
//    boolean dp[][];
//    void build(String s){
//     int n=s.length();
//     dp=new boolean[n][n];

//     for(int i=0;i<n;i++){
//         dp[i][i]=true;
//     }
//     for(int len=2;len<=n;len++){
//         for(int start=0;len+start-1<n;start++){
//             int end=start+len-1;
//             if(s.charAt(start)==s.charAt(end)){
//                 if(len==2||dp[start+1][end-1]){
//                     dp[start][end]=true;

//                 }
//             }
//         }
//     }

//    }
//     public List<List<String>> partition(String s) {
//         List<List<String>>res=new ArrayList<>();
//         List<String>curr=new ArrayList<>();
//         build(s);
//         helper(res,curr,0, s);
//         return res;
//     }
//     void helper(List<List<String>>res,List<String>curr,int idx,String s){
//         if(idx==s.length()){
//             res.add(new ArrayList<>(curr));
//             return;
//         }

//         for(int i=idx;i<s.length();i++){
//             if(dp[idx][i]){
//                 curr.add(s.substring(idx,i+1));
//                 helper(res,curr,i+1,s);
//                 curr.remove(curr.size()-1);

//             }

//         }
//     }
// }
class Solution {
    boolean dp[][];  // For palindrome checking
    List<List<String>> memo[][];  // 2D memo array for partitions
    
    void build(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        
        // Initialize single character palindromes
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Build palindrome DP table
        for(int len = 2; len <= n; len++) {
            for(int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                if(s.charAt(start) == s.charAt(end)) {
                    if(len == 2 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                    }
                }
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        build(s);
        // Initialize memo array: n x n (though we'll only use from each idx to end)
        memo = new List[n][n];
        return helper(0, s.length() - 1, s);
    }
    
    List<List<String>> helper(int start, int end, String s) {
        // Base case: empty substring
        if(start > end) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        
        // Check memo
        if(memo[start][end] != null) {
            return memo[start][end];
        }
        
        List<List<String>> res = new ArrayList<>();
        // Try all possible palindrome substrings from start
        for(int i = start; i <= end; i++) {
            if(dp[start][i]) {
                String curr = s.substring(start, i + 1);
                List<List<String>> subPartitions = helper(i + 1, end, s);
                for(List<String> sub : subPartitions) {
                    List<String> partition = new ArrayList<>();
                    partition.add(curr);
                    partition.addAll(sub);
                    res.add(partition);
                }
            }
        }
        
        // Store in memo
        memo[start][end] = res;
        return res;
    }
}