class Solution {
    public int numTilePossibilities(String tiles) {
        int freq[]=new int[26];
        for(char c:tiles.toCharArray()){
            freq[c-'A']++;

        }
        return getCount(freq);
        
    }
    int  getCount(int freq[]){
        int n=freq.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(freq[i]==0) continue;
            count++;
            freq[i]--;
            count+=getCount(freq);
            freq[i]++;
        }
        return count;

    }
}