class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer>st=new HashSet<>();
        for(int i:nums)st.add(i);
        if(!st.contains(original))return original;
        int num=original;
        while(st.contains(num)){
            num*=2;
        }
        return num;
    }
}