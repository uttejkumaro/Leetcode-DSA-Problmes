class CustomStack {
    int stack[];
     int start=0;

    public CustomStack(int maxSize) {
         stack=new int [maxSize];
        //int top=stack[maxSize]-1;
       
        
    }
    
    public void push(int x) {
        if(start<stack.length){
        stack[start]=x;
        start++;
        }
        
    }
    
    public int pop() {
        if(start==0) return -1;
       else  if(start>0){
        start--;
        
       }return stack[start];
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k;i++){
            if(i<stack.length){
                stack[i]+=val;
            }
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */