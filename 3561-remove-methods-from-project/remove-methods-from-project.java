class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int invSize = invocations.length;
        List<List<Integer>> adjList = new ArrayList<>();
        buildAdjList(adjList, invocations, invSize, n);

        HashSet<Integer> nodesAlongPath = new HashSet<>(); //to track all affected nodes
        dfs(k, adjList, new boolean[n], nodesAlongPath);
        List<Integer> res = new ArrayList<>();
        for(int[] invocation : invocations){
            int invoker = invocation[0];
            int invoked = invocation[1];
            if(!nodesAlongPath.contains(invoker) && nodesAlongPath.contains(invoked)){
                return generateResult(nodesAlongPath, res, n, false);
            }
        }
        return generateResult(nodesAlongPath, res, n, true);
    }
    private List<Integer> generateResult(HashSet<Integer> nodesAlongPath, List<Integer> res, int n, boolean toRemove){
        for(int i = 0; i < n; i ++){
            if(toRemove){
                if(!nodesAlongPath.contains(i)){
                    res.add(i);
                }
            }else{
                res.add(i);
            }
        }
        return res;
    }
    private void dfs(int curr, List<List<Integer>> adjList, boolean[] visited, HashSet<Integer> nodesAlongPath){
        if(visited[curr]) {
            return;
        }

        visited[curr] = true;
        nodesAlongPath.add(curr);
        for(int neighbor : adjList.get(curr)){
            if(!visited[neighbor]) dfs(neighbor, adjList, visited, nodesAlongPath);
        }
    }

    private void buildAdjList(List<List<Integer>> adjList, int[][] invocations, int invSize, int numberOfVertices){
        for(int i = 0; i < numberOfVertices; i += 1){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < invSize; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            adjList.get(u).add(v);
        }
    }
}