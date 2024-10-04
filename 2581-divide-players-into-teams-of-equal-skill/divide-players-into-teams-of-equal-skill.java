class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        Arrays.sort(skill);
        int sum=skill[0]+skill[n-1];
        long res=0;
        for(int i=0;i<n/2;i++){
            int curr=skill[i]+skill[n-i-1];
            if(curr!=sum) return -1;
            else{
                res+=(long)skill[n-i-1]*skill[i];
            }
        }
        return res;
        
    }
}