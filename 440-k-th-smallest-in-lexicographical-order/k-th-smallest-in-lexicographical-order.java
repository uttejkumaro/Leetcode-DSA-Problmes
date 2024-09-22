// //mle
// class Solution {
//     void findKthNumber(int curr,int n, int k,List<Integer>res){
//         if(curr>n) return;
//          res.add(curr);
//         for(int i=0;i<=9;i++){
//             int dig=curr*10+i;
//             if(dig>n) return;
//             findKthNumber(dig,n,k,res);
//         }

//     }
//     public int findKthNumber(int n, int k) {
//         List<Integer>res=new ArrayList<>();
//         for(int i=1;i<=9;i++){
//             findKthNumber(i,n,k,res);
//         }
//         return res.get(k-1);

        
//     }
// }
class Solution {
	public int findKthNumber(int n, int k) {
		int curr = 1;
		k--; 
		while (k > 0) {
			int steps = countSteps(n, curr, curr + 1);
			if (steps <= k) {
				curr++;
				k -= steps; 			
			}
            else{
                curr*=10;
                k--;
            }
		}
		return curr;
	}
	private int countSteps(int n, long curr, int next) {
		int steps = 0;
		while (curr <= n) {
			steps += Math.min(n + 1, next) - curr;
			curr *= 10;
			next *= 10; 
		}
		return steps;
	}
}

