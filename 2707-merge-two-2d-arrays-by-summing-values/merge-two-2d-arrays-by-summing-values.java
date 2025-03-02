class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // int n1=nums1.length;
        // int n2=nums.length;     
        
        TreeMap<Integer,Integer>tp=new TreeMap<>();
        for(int arr[]:nums1){
            int a=arr[0];
            int b=arr[1];
            if(tp.containsKey(a)){
                tp.put(a,tp.get(a)+b);
            }
            else{

            tp.put(a,b);
            }
        }
          for(int arr[]:nums2){
            int a=arr[0];
            int b=arr[1];
            if(tp.containsKey(a)){
                tp.put(a,tp.get(a)+b);
            }
            else{

            tp.put(a,b);
            }
        }
        ArrayList<int[]>al=new ArrayList<>();
        for(Map.Entry<Integer,Integer>e:tp.entrySet()){
            al.add(new int []{e.getKey(),e.getValue()});
        }
        return al.toArray(new int[al.size()][]);

        
    }
}