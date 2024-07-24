class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int arr[]=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int x=0;
            int y=num;
            int p=1;
            if(y==0){
                x=mapping[0];
            }
            while(y>0){
                int base=y%10;
                int newB=mapping[base];
                x=x+p*(newB);
                p=p*10;
                y=y/10;
            }
            arr[i]=x;
        }
        pair ans[]=new pair[nums.length];

        for(int i=0;i<nums.length;i++){
            ans[i]=new pair(nums[i],arr[i]);
        }
        Arrays.sort(ans,(a,b)->a.newE-b.newE);

        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=ans[i].oldE;
        }
        return res;
    }
}
class pair{
    int oldE;
    int newE;
    pair(int o,int n){
        this.oldE=o;
        this.newE=n;
    }
}