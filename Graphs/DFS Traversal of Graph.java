//{ Driver Code Starts
// Initial Template for Java
// import java.util.*;
// import java.lang.*;
// import java.io.*;
// class GFG {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br =
//             new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine().trim());
//         while (T-- > 0) {
//             String[] s = br.readLine().trim().split(" ");
//             int V = Integer.parseInt(s[0]);
//             int E = Integer.parseInt(s[1]);
//             ArrayList<ArrayList<Integer>> adj =
//                 new ArrayList<ArrayList<Integer>>();
//             for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
//             for (int i = 0; i < E; i++) {
//                 String[] S = br.readLine().trim().split(" ");
//                 int u = Integer.parseInt(S[0]);
//                 int v = Integer.parseInt(S[1]);
//                 adj.get(u).add(v);
//                 adj.get(v).add(u);
//             }
//             Solution obj = new Solution();
//             ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
//             for (int i = 0; i < ans.size(); i++)
//                 System.out.print(ans.get(i) + " ");
//             System.out.println();
//         }
//     }
// }

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        vis[0] = true;
        dfs(0 , vis , ans , adj);
        return ans;
    }
    public void dfs(int node , boolean[] visited , ArrayList<Integer> DFS_ans , ArrayList<ArrayList<Integer>> adj){
        //making the current node as visited
        visited[node] = true;
        //adding current node in the ans list
        DFS_ans.add(node);
        //finding the neighbouring nodes of the cureent node
        for(int i : adj.get(node)){
            //if the neighbour node of the current node is not visited yet, then call dfs for that node 
            if(visited[i] == false){
                dfs(i , visited , DFS_ans , adj);  //recursively calling dfs for neighboring nodes of the current node
            }
        } 
    }
}
