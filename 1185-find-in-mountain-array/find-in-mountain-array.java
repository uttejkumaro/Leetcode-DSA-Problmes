/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
// class Solution {
//     public int findInMountainArray(int target, MountainArray mountainArr) {
//         int n=mountainArr.length();
//         for(int i=0;i<n;i++){
//             if(mountainArr.get(i)==target ) return i;
//         }
//         return -1;
//     }
// }
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int peak=findPeak(mountainArr,n);
        int leftRes=binarySearch(target,mountainArr,0,peak,true);
        if(leftRes!=-1) return leftRes;
       return binarySearch(target,mountainArr,peak+1,n-1,false);

    }
    int findPeak(MountainArray arr,int n){
        int left=0;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr.get(mid)<arr.get(mid+1)){
                left=mid+1;
            }
            else{

                right=mid;
            }
        }
        return left;
        
    }
    int binarySearch(int target,MountainArray arr,int left,int right,boolean ascending){
        while(left<=right){
            int mid=left+(right-left)/2;
            int midVal=arr.get(mid);
            if(midVal==target ) return mid;
            if(ascending){//normal b.s
                if(midVal<target) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }

            }else {
                if(midVal>target) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }

            }

        }
        return -1;
    }

}