//twopointer approach-binary search
class Solution {
    public int maxArea(int[] height) {
        int res,l,r;
        res=0;
        l=0;
        r=height.length-1;
        while(l<r){
            int area=(r-l)*Math.min(height[l],height[r]);
            res=Math.max(res,area);
            if(height[l]>height[r]){
                r-=1;
            }
            else if(height[l]<height[r]){
                l+=1;
            }
            else{
                r-=1;
            }
        }
        return res;
        
    }
}