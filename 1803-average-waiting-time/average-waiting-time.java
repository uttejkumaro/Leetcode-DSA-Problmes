//cpu schduling -fcfs
class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currT=0;//current time
        double twt=0;//total waiting time
        for(int customer[]:customers){
            int AT=customer[0];//arival time
            int BT=customer[1];//busy time
        
        if(currT<AT){//currT is idle so move to AT
        currT=AT;
        }
        twt+=(currT-AT)+BT;
        currT+=BT;
        }
        return twt/customers.length;

        
    }
}   