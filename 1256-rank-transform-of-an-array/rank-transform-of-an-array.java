class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n=arr.length;
        //arrays.clone()
        int res[]=Arrays.copyOf(arr,n);
      HashMap<Integer,Integer>map=new HashMap<>();
      Arrays.sort(arr);
        int rank=1;
      for(int i=0;i<n;i++){
        if(!map.containsKey(arr[i]))
        map.put(arr[i],rank++);
      }
      for(int i=0;i<n;i++){
        res[i]=map.get(res[i]);
      }
      return res;
        
    }
}