class Solution {
    public boolean lemonadeChange(int[] bills) {

     int n=bills.length;
     int fiveCount=0;
     int tensCount=0;
     for(int bill:bills){
        if(bill==5) fiveCount++;
        else if(bill==10){
            if(fiveCount>0){
                fiveCount--;
                tensCount++;
            }
            else return false;
        }
        else if(bill==20){
            if(tensCount >0 && fiveCount>0){
                tensCount--;
                fiveCount--;
            }
            else if(fiveCount>=3){
                fiveCount-=3;
            }
            else {
                 return false;

            }
           
        }
     }
     return true;
     
        
    }
}