class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0;
        List<Integer>li=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int out[]=new int[li.size()];
        for(int k=0;k<li.size();k++){
            out[k]=li.get(k);
        }
        return out;
    }
}