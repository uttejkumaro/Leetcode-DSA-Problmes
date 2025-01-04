class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int freq[][]=new int[26][n];
        //build freq table
        for(int i=0;i<n;i++){
            if(i>0){
                for(int j=0;j<26;j++){
                    freq[j][i]=freq[j][i-1];

                }
            }
            freq[s.charAt(i)-'a'][i]++;
        }
        Set<String>uniquePali=new HashSet<>();
        for(int i=1;i<n-1;i++){
            for(char c='a';c<='z';c++){
                int idx=c-'a';
                if(freq[idx][i-1]>0 && freq[idx][n-1]-freq[idx][i]>0){
                    uniquePali.add(c+""+s.charAt(i)+c);
                }
            }
        }
        return uniquePali.size();
        
        
    }
}