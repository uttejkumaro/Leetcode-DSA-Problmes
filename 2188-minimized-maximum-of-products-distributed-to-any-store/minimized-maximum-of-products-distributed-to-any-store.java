// class Solution {
//     public int minimizedMaximum(int n, int[] quantities) {
//         if(n==1) return quantities[0];
//         Arrays.sort(quantities);
//         int m=quantities.length;
//         if(m==n) return quantities[m-1];
//             int sum=0;
//         for(int i:quantities){
//             sum+=i;
//         }
//         int res=(int)Math.ceil((double)sum/n);
//         return res;
        
//     }
// }
import java.util.*;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        PriorityQueue<int[]> typeStorePairs = new PriorityQueue<>((a, b) ->
            Long.compare((long) b[0] * a[1], (long) a[0] * b[1])
        );
        for (int quantity : quantities) {
            typeStorePairs.offer(new int[] { quantity, 1 });
        }
        for (int i = 0; i < n - m; i++) {
            int[] pair = typeStorePairs.poll();
            typeStorePairs.offer(new int[] { pair[0], pair[1] + 1 });
        }
        int[] pair = typeStorePairs.poll();
        return (int) Math.ceil((double) pair[0] / pair[1]);
    }
}

