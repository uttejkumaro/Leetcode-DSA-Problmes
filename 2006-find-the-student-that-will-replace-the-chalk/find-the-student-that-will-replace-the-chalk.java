class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long s=0;
        for(int i:chalk){  
            s+=i;
        }
        int n=chalk.length;
        // for(int i=0;i<n;i++){
        //     while(s<k) s=k-s;
        // }
        //for remaining use modulo
       // k=k%s //;oose conerstion java wont hadel tpe cast if we implict sppecify so error therow
         k%=s;
        for(int i=0;i<n;i++){
            if(chalk[i]>k){
                return i;
            }
            k-=chalk[i];
          
        }
        return 0;
    }
}