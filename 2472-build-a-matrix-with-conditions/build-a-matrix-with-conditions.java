class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);
        
        if (rowOrder == null || colOrder == null) {
            return new int[0][0]; // If sorting is not possible, return an empty matrix
        }
        
        int[][] result = new int[k][k];
        int[] pos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            pos[colOrder[i]] = i;
        }
        
        for (int i = 0; i < k; i++) {
            result[i][pos[rowOrder[i]]] = rowOrder[i];
        }
        
        return result;
    }
    
    private int[] topologicalSort(int k, int[][] conditions) {
        List<Integer>[] graph = new List[k + 1];
        int[] inDegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] condition : conditions) {
            graph[condition[0]].add(condition[1]);
            inDegree[condition[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[k];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            
            for (int next : graph[curr]) {
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return index == k ? order : null; // If topological sort is not possible, return null
    }

}