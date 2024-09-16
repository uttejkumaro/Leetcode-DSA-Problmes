class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minTime= Integer.MAX_VALUE;
        Collections.sort(timePoints);
        List<Integer>minutes=new ArrayList<>();
        for (String time:timePoints) {
            String[] parts=time.split(":");
            int hours=Integer.parseInt(parts[0]);
            int mins=Integer.parseInt(parts[1]);
            minutes.add(hours*60 +mins);
        }
        Collections.sort(minutes);
        for (int i = 1; i < minutes.size(); i++) {
            minTime = Math.min(minTime,minutes.get(i)-minutes.get(i-1));
        }
        int wrapAroundDifference= (24*60-minutes.get(minutes.size() -1))+minutes.get(0);
        minTime = Math.min(minTime,wrapAroundDifference);
        
        return minTime;
    }
}
