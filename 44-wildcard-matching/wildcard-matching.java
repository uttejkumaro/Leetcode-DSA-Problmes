// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n=s.length();
//         int m=p.length();
//         return helper(0,0,n,m,s,p);
        
//     }
//     boolean helper(int idx1,int idx2,int n,int m,String s,String p){
//         if (idx1==n){
//             while(idx2<m){
//                 if(p.charAt(idx2++)!='*') return false;

//             }
//             return true;
//         }
//         if(idx2==m) return false;
//         if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='?')
//         return helper(idx1+1,idx2+1,n,m,s,p);
//         else if(p.charAt(idx2)=='*'){
//             //choice 1-Treat * as emmpty space in p and move to next p index
//             boolean choice1=helper(idx1,idx2+1,n,m,s,p);
//             boolean choice2=helper(idx1+1,idx2,n,m,s,p);
//             return choice1||choice2;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int memo[][]=new int [n][m];
        for(int row[]:memo){
            Arrays.fill(row,-1);
        }
        return helper(0,0,n,m,s,p,memo);
        
    }
    boolean helper(int idx1,int idx2,int n,int m,String s,String p,int memo[][]){
        boolean result=false;
        if (idx1==n){
            while(idx2<m){
                if(p.charAt(idx2++)!='*') return false;

            }
            return true;
        }
        if(idx2==m) return false;
        if(memo[idx1][idx2]!=-1) return memo[idx1][idx2]==1?true:false;
        if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='?')
         result= helper(idx1+1,idx2+1,n,m,s,p,memo);
        else if(p.charAt(idx2)=='*'){
            //choice 1-Treat * as emmpty space in p and move to next p index
            boolean choice1=helper(idx1,idx2+1,n,m,s,p,memo);
            boolean choice2=helper(idx1+1,idx2,n,m,s,p,memo);
            result=choice1||choice2;
        }
        memo[idx1][idx2]=result?1:0;
        return result;
    }
}