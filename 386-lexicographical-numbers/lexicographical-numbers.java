class Solution {
    void  lexicalOrder(int curr,int n,List<Integer> res){
        if(curr>n) return ;
        res.add(curr);
        for(int i=0;i<10;i++){
           int  newInt=curr*10+i;
            if(newInt>n)return;
            lexicalOrder(newInt,n,res);
            
        }
     
        
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer>res=new ArrayList<>();
        for(int i=1;i<=9;i++){
           lexicalOrder(i,n,res);
        }
        return res;     

      
        
    }
}