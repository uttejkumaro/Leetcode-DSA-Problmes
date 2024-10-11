class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int time[]=times[targetFriend];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        int chairt[]=new int[n];
        for(int t[]:times){
            for(int i=0;i<n;i++){
                if(chairt[i]<=t[0]){
                    chairt[i]=t[1];
                    if(Arrays.equals(t,time)) return i;
                    break;
                }
            }
        
        }
        return 0;

        
    }
}