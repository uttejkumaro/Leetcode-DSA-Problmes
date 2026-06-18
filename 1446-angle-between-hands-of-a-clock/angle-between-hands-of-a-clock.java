class Solution {
    public double angleClock(int hour, int minutes) {
        double ans=Math.abs((30*hour-5.5*minutes));
        return ans>180.0?360-ans:ans;
    }
}