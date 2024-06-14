//t.c O(nlogn)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]>res=new ArrayList<>();
        int newInterval[]=intervals[0];
        res.add(newInterval);
       
        for(int i[]:intervals){
            if (i[0]<=newInterval[1]){ //works form 2nd interval
                newInterval[1]=Math.max(newInterval[1],i[1]);//checking max end value for ffirst and next 
            }
            else{
                newInterval=i;
                res.add(newInterval);
            }

        }
        return res.toArray(new int[res.size()][]);//converting res into 2d array 

    }
}
/* dry run 
Given intervals [[1, 3], [2, 6], [8, 10], [15, 18]], let's see how i[0] is used:

Initial Intervals: [[1, 3], [2, 6], [8, 10], [15, 18]]
Sorted Intervals: [[1, 3], [2, 6], [8, 10], [15, 18]] (already sorted)
Iteration:

First Interval: [1, 3]
newInterval = [1, 3]
Added to res: res = [[1, 3]]
Second Interval: [2, 6]
interval[0] = 2, newInterval[1] = 3
2 <= 3 is true, so merge: newInterval[1] = Math.max(3, 6) = 6
newInterval becomes [1, 6]
res is updated: res = [[1, 6]]
Third Interval: [8, 10]
interval[0] = 8, newInterval[1] = 6
8 <= 6 is false, so no merge: newInterval = [8, 10]
Added to res: res = [[1, 6], [8, 10]]
Fourth Interval: [15, 18]
interval[0] = 15, newInterval[1] = 10
15 <= 10 is false, so no merge: newInterval = [15, 18]
Added to res: res = [[1, 6], [8, 10], [15, 18]]
Final merged intervals: [[1, 6], [8, 10], [15, 18]].*/