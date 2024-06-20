class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int lcs=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currentnum=num;
                int cs=1;
                while(set.contains(currentnum+1)){
                    currentnum+=1;
                    cs+=1;

                }
                lcs=Math.max(lcs,cs);
            }

        }
        return lcs;

    }
}