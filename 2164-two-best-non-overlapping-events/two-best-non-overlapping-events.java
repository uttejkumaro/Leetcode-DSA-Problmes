//https://www.youtube.com/watch?v=gdBsvEOeYho&t=1248s
//line sweep algo
class Solution {
    public int maxTwoEvents(int[][] events) {
        ArrayList<int[]>al=new ArrayList<>();
        for(int i[]:events){
            al.add(new int[]{i[0],1,i[2]});
            al.add(new int[]{i[1]+1,-1,i[2]});

        }
       // al.sort((a,b)->(a[0]-b[0]));
       //if both same
       al.sort((a,b)->(a[0] !=b[0]?a[0]-b[0]:a[1]-b[1]));
 
        int max=0,maxSoFar=0;
        for(int []i:al){
            int st=i[0];
            int e=i[1];
            int val=i[2];
            if(e==1){
                max=Math.max(max,maxSoFar+val);

            }
            else{
                maxSoFar=Math.max(maxSoFar,val);
            }

           }
           return max;


        
    }
}