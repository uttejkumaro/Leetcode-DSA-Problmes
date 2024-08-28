class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double []> conns[] = new ArrayList[n];
        for(int i = 0; i < n; i++)  conns[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int edge[] = edges[i];
            conns[edge[0]].add(new double[]{edge[1], succProb[i]});
            conns[edge[1]].add(new double[]{edge[0], succProb[i]});
        }
        
        double scores[] = new double[n];
        scores[start] = 1d;
        Queue<Pair<Integer, Double>> pq = new PriorityQueue<>((e1, e2)->(e1.getValue() > e2.getValue() ? -1 : 1));
        pq.add(new Pair<>(start, 1d));
        while(!pq.isEmpty()){
            Pair<Integer, Double> curr = pq.poll();
            start = curr.getKey();
            double score = curr.getValue();
            if(start == end)    break;
            for(double conn[]: conns[start]){
                int next = (int)conn[0];
                if(scores[next] < scores[start] * conn[1]){
                    scores[next] = scores[start] * conn[1];
                    pq.add(new Pair<>(next, scores[next]));
                }
            }
        }   
        return scores[end];
    }
}