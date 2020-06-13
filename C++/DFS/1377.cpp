class Solution 
{
private:
    double dfs(unordered_map<int, unordered_set<int>>& graph, int node, int time, double prob, int arrivalTime, int target, int queryTime)
    {
        if(time >= queryTime && node != target) return 0.0;
        
        if(node == target)
        {
            arrivalTime = time;
            if(queryTime < time) return 0.0;
            return (graph[node].empty())? prob : ((queryTime == arrivalTime)? prob : 0.0);
        }
        else
        {
            int size = graph[node].size();
            for(int next : graph[node])
            {
                graph[next].erase(node);
                double nextP = prob * ((double)1/size);
                double p = dfs(graph, next, time+1, nextP, arrivalTime, target, queryTime);
                if(p != 0.0) return p;
            }
            return 0.0;
        }
    }
    
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) 
    {
        unordered_map<int, unordered_set<int>> graph;
        for(auto edge : edges)
        {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        double prob = 1.0;
        int arrivalTime = INT_MAX;
        return dfs(graph, 1, 0, prob, arrivalTime, target, t);
    }
};