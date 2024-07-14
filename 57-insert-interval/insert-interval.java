class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 3 cases 
        //1.no overlapping of new and present inter- 1.it can be before or after 
        //2.overalpping then [a,b] a=min b=max of two 
        List<int []>res=new ArrayList<>();
        for(int []interval:intervals){
            //no overlapping 1.new is after old
            if(newInterval ==null || interval[1]<newInterval[0]){
                res.add(interval);
            }
            //2.new is before old
            else if(interval[0]>newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval=null;
            }
            else{
                newInterval[0]=Math.min(interval[0],newInterval[0]);
                newInterval[1]=Math.max(interval[1],newInterval[1]);
            }
        }
         if (newInterval != null) {
            res.add(newInterval);
        }
         return res.toArray(new int[res.size()][]);
    }
}