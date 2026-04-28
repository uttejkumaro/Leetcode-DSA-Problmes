class Solution {
    public int minOperations(int[][] grid, int x) {
       ArrayList<Integer>al=new ArrayList<>();
        int rem = grid[0][0] % x;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] % x != rem) return -1;
                al.add(grid[i][j]);
            }
        }
        Collections.sort(al);
        System.out.println(al);
        int median=al.size()/2;
        int ops=0;
        for(int i=0;i<al.size();i++){
           ops+=Math.abs(al.get(median)-al.get(i))/x;
          System.out.println(ops);
        }
        return ops;

    }
}