class Solution 
{
    private double dfs(Map<Integer, Set<Integer>> graph, int node, int time, double prob, int arrivalTime, int target, int queryTime)
    {
        if(time >= queryTime && node != target) return 0.0;
        
        if(node == target)
        {
            arrivalTime = time;
            if(queryTime < time) return 0.0;
            return (graph.get(node).isEmpty())? prob : ((queryTime == arrivalTime)? prob : 0.0);
        }
        else
        {
            int size = graph.get(node).size();
            for(int next : graph.getOrDefault(node, new HashSet<Integer>()))
            {
                graph.get(next).remove(node);
                double nextP = prob * ((double)1/size);
                double p = dfs(graph, next, time+1, nextP, arrivalTime, target, queryTime);
                if(p != 0.0) return p;
            }
            return 0.0;
        }
    }
    
    public double frogPosition(int n, int[][] edges, int t, int target) 
    {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++) if(!graph.containsKey(i)) graph.put(i, new HashSet<Integer>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        double prob = 1.0;
        int arrivalTime = Integer.MAX_VALUE;
        return dfs(graph, 1, 0, prob, arrivalTime, target, t);
    }
}