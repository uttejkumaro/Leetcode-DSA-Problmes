class Solution {
    public int largestCombination(int[] candidates) {
        if(candidates.length==1)return 1;
        int n=candidates.length;
        int and=1;
        for(int i=0;i<n;i++){
            and&=candidates[i];
            if(and==0) break;
            
        }
        if(and!=0 ) return n;
        int count[]=new int[32];
        for( int i:candidates ){
            for(int j=0;j<32;j++){
                if((i&(1<<j))!=0) count[j]++;
            }
            
        }
        Arrays.sort(count);
        return count[31];


        
    }
}