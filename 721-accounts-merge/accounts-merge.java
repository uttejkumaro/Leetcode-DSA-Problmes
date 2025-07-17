class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //List<List<String>>res=new ArrayList<>();
        Map<String,List<String>>graph=new HashMap<>();
        Map<String,String>email=new HashMap<>();
        for(var account:accounts){
            String name =account.get(0);
            for(int j=1;j<account.size();j++){
                String emai=account.get(j);
                email.put(emai,name);
                graph.putIfAbsent(emai,new ArrayList<>());
                if(j>1){
                    graph.get(account.get(j-1)).add(emai);
                    graph.get(emai).add(account.get(j-1));
                }
            }
        }
          Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String em : graph.keySet()) {
            if (!visited.contains(em)) {
                List<String> group = new ArrayList<>();
                dfs(em, graph, visited, group);
                Collections.sort(group);
                group.add(0, email.get(em)); 
                result.add(group);
            }
        }

        return result;
    }

    private void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> group) {
        visited.add(email);
        group.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, group);
            }
        }
    }        
    
}