// class Pair{
//     int node;
//     int parent;
//     public Pair(int node, int parent){
//         this.node = node;
//         this.parent = parent;
//     }
// }
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i=0 ; i<V ; i++){
            vis[i] = false;
        }
        for(int i=0 ; i<V ; i++){
            if(vis[i] == false){
                // if(bfs(i , vis , adj)) return true;
                if(dfs(i , -1, vis , adj)) return true;
            }
        }
        return false;
    }
    // public boolean bfs(int src , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
    //     vis[src] = true;
    //     Queue<Pair> q = new LinkedList<Pair>();
    //     q.offer(new Pair(src , -1));
    //     while(!q.isEmpty()){
    //         int node = q.peek().node;
    //         int parent = q.peek().parent;
    //         q.poll();
            
    //         for(int adjnode : adj.get(node)){
    //             if(vis[adjnode] == false){
    //                 vis[adjnode] = true;
    //                 q.offer(new Pair(adjnode, node));
    //             }
    //             else if(parent != adjnode){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public boolean dfs(int node , int parent , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int adjnode : adj.get(node)){
            if(vis[adjnode] == false){
                if(dfs(adjnode , node , vis , adj)) return true;
            }
            else if(parent != adjnode) return true;
        }
        return false;
    }
}
