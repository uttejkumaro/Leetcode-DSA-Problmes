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
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // Palindrome lookup table
        List<List<List<String>>> partitions = new ArrayList<>(n + 1);
        
        // Initialize partition list
        for (int i = 0; i <= n; i++) {
            partitions.add(new ArrayList<>());
        }
        partitions.get(0).add(new ArrayList<>()); // Base case: empty partition
        
        // Build DP table for palindromes (O(n^2))
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    String substring = s.substring(start, end + 1);
                    
                    // Add valid partitions
                    for (List<String> prevPartition : partitions.get(start)) {
                        List<String> newPartition = new ArrayList<>(prevPartition);
                        newPartition.add(substring);
                        partitions.get(end + 1).add(newPartition);
                    }
                }
            }
        }
        
        return partitions.get(n);
    }
}

