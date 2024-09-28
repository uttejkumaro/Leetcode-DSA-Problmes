class MyCircularDeque {

    int deque[];
    int front;
    int rear;
    int size;
    int cap;

    public MyCircularDeque(int k) {
         deque=new int [k];
        front=-1;
        rear=-1;
        size=0;
        cap=k;
        
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()) front=rear=0;
        else if(front==0) front=cap-1;
        else{
            front--;;
        }
        deque[front]=value;
        size++;     
        return true;  
        
        
    }
    
    public boolean insertLast(int value) {
         if(isFull()) return false;
        if(isEmpty()) front=rear=0;
        else if(rear==cap-1){
            rear=0;
        }
        else{
            rear++;
        }
        deque[rear]=value;
        size++;     
        return true;  


        
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(front==rear) front=rear=-1;
        else if(front==cap-1) front=0; 
        else front++;
        size--;
        return true;
        
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(front==rear) front=rear=-1;
        else if(rear==0) rear=cap-1; 
        else rear--;
        size--;
        return true;
        
    }
    
    public int getFront() {
        return isEmpty()?-1:deque[front];

        
    }
    
    public int getRear() {
           return isEmpty()?-1:deque[rear];
        
    }
    
    public boolean isEmpty() {
        return size==0;
        
    }
    
    public boolean isFull() {
        return size==cap;
       
        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */