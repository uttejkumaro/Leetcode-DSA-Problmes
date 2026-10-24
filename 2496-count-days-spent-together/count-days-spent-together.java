class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
       int months[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       int start1=getDate(arriveAlice,months);
       int end1=getDate(leaveAlice,months);
       int start2=getDate(arriveBob,months);
       int end2=getDate(leaveBob,months);
       int start=Math.max(start1,start2);
       int end=Math.min(end1,end2);
       int ans=Math.max(0,end-start+1);
       return ans;
    }
    //getDate-gives value of that date in 365 days;
    int getDate(String date,int months[]){
        int month=Integer.parseInt(date.substring(0,2));
        int day=Integer.parseInt(date.substring(3,5));
        for(int i=0;i<month-1;i++){
            day+=months[i];
        }
        return day;
    }
}