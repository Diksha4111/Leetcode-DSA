class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int path[] = new int[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfs(i, adj, vis, path) == true) return true; 
            }
        }
        return false; 
    }
  //method for dfs traversal
  public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int path[]) {
        vis[node] = 1; 
        path[node] = 1; 
        
        // traverse for adjacent nodes 
        for(int adjnode : adj.get(node)) {
            // when the node is not visited 
            if(vis[adjnode] == 0) {
                if(dfs(adjnode, adj, vis, path) == true) 
                    return true; 
            }
            // if the node has been previously visited
            // but it has to be visited on the same path 
            else if(path[adjnode] == 1) {
                return true; 
            }
        }
        
        path[node] = 0; 
        return false; 
    }
}
