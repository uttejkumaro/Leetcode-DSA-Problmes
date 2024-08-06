class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        int count []=new int [26];
        for(char c:word.toCharArray()){
            count[c-'a']++; 
        }
        Arrays.sort(count);
        for(int i=0;i<count.length;i++){
            int n=count.length;
            ans+=count[n-i-1]*(i/8+1);
        }
        return ans;
    }
}