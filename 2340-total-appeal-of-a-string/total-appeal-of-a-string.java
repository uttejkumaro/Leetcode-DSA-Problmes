class Solution {
    public long appealSum(String s) {
        int n=s.length();
        long total=0;
        int lstWord[]=new int[26];
        Arrays.fill(lstWord,-1);
        long curr=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int idx=c-'a';
            curr+=(i-lstWord[idx]);
            lstWord[idx]=i;
            total+=curr;
        }
        return total;

        
    }
}