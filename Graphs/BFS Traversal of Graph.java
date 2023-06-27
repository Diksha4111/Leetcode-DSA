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
//             ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//             for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
//             for (int i = 0; i < E; i++) {
//                 String[] S = br.readLine().trim().split(" ");
//                 int u = Integer.parseInt(S[0]);
//                 int v = Integer.parseInt(S[1]);
//                 adj.get(u).add(v);
//                 // adj.get(v).add(u);
//             }
//             Solution obj = new Solution();
//             ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
//             for (int i = 0; i < ans.size(); i++)
//                 System.out.print(ans.get(i) + " ");
//             System.out.println();
//         }
//     }
// }

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ansBFS = new ArrayList<Integer>(); //to store traversal ans
        boolean[] visited = new boolean[V]; //to store visited ot not visited detail
        Queue<Integer> q = new LinkedList<Integer>(); //to store nodes of the graph
        //add starting node of the graph in the queue
        q.offer(0);
        //make starting node of the graph as visited
        visited[0] = true;
        while(!q.isEmpty()){
            //poll top element of queue and insert it into ansList
            int curr = q.poll();
            ansBFS.add(curr);
            
            //for the current node check for its neighbours in the adjacency list
            for(int i : adj.get(curr)){
                //if the neighbours exists and haven't been visited, make them visited and add them in the queue 
                if(visited[i] == false){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return ansBFS;
    }
}
