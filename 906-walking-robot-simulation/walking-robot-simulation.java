class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n=commands.length;
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};//dir-n e s w
        int x=0,y=0,dir=0;
        int res=0;
        HashSet<String>set=new HashSet<>();
        for(int obs[]:obstacles){
            set.add(obs[0]+","+obs[1]);
        }
        for(int cmd:commands){
            if(cmd==-2){
                dir=(dir+3)%4;
            }
            else if(cmd==-1){
                dir=(dir+1)%4;
            }
            else{
                for(int k=0;k<cmd;k++){
                    int x1=x+dirs[dir][0];
                    int y1=y+dirs[dir][1];
                    if(!set.contains(x1+","+y1)){
                        x=x1;
                        y=y1;
                        res=Math.max(res,x*x+y*y);

                    }
                    else{
                        break;
                    }

                }
            }
        }
        return res;
    }
}