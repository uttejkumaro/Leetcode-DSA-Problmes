class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0,j=0;
       int  m=nums1.length;
       int  n=nums2.length;
       List<Integer>li=new ArrayList<>(); 
        while (i<m && j<n){
            if (nums1[i] == nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i]<nums2[j]){
                i++;
            }
            else {
                j++;

            }
        }
        int res[]=new int[li.size()];
        for(int k=0;k<li.size();k++){
            res[k]=li.get(k);
        }return res;
        
        
    }
}