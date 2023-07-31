class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        //initial configurations
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int isSafeNode[] = new int[V];
        //creating adjlist
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }

        //if graph has connected components
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, isSafeNode);
            }
        }

        //creating ans list
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isSafeNode[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
    }
    //dfs method
    public boolean dfs(int node, List<List<Integer>> adj, int vis[], 
    int path[], int isSafeNode[]) {
        vis[node] = 1;
        path[node] = 1;
        isSafeNode[node] = 0;
        // traverse for adjacent nodes
        for (int adjnode : adj.get(node)) {
            // when the node is not visited
            if (vis[adjnode] == 0) {
                if (dfs(adjnode, adj, vis, path, isSafeNode) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (path[adjnode] == 1) {
                return true;
            }
        }
        isSafeNode[node] = 1;
        path[node] = 0;
        return false;
    }
}
