//queue
/* O(n*k)
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);           
        } 
        while(queue.size()>1){
            for(int i=1;i<k;i++){
            queue.add(queue.remove());           
        }
        queue.remove(); 
        }
        return queue.peek();     
        
    }
}
*/
//recursive
class Solution {
    public int findTheWinner(int n, int k) {
        return find(n,k)+1;

    }
    int find(int n,int k){
        if(n==1){
            return 0;
            }
        return (find((n-1),k)+k)%n;
    }
}

