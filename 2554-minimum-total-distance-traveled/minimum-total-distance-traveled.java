class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,Comparator.comparingInt(a->a[0]));
        List<Integer>pos=new ArrayList<>();
        for(int []f:factory){
            for(int i=0;i<f[1];i++){
                pos.add(f[0]);
            }
        }
        int rcount=robot.size();
        int fcount=pos.size();
        
        
        long memo[][]=new long[rcount][fcount];
        for (long[] row : memo) Arrays.fill(row, -1);
        return calMin(0,0,robot,pos,memo);
        
    }
    long calMin(int ridx,int fidx,List<Integer>robot,List<Integer>pos,long memo[][]){
        
        if(ridx==robot.size()) return 0;
        if(fidx==pos.size()) return (long)1e12;
        if (memo[ridx][fidx] != -1) return memo[ridx][fidx];
        long pick=Math.abs(robot.get(ridx)-pos.get(fidx))+calMin(ridx+1,fidx+1,robot,pos,memo);
        long skip=calMin(ridx,fidx+1,robot,pos,memo);
        memo[ridx][fidx]=Math.min(pick,skip);
        return memo[ridx][fidx];

    }
}