/*
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=target[i]) return false;
        }
        return true;
        
    }
}
*/
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int rev[]=new int[1001];
        for(int i:arr) rev[i]++;
        for(int i:target) rev[i]--;
        for(int i:rev) {
            if(i!=0) return false;
        }
        return true;
        
        }
}