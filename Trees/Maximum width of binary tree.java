/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
} 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root == null){
            return ans;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int s = q.size();
            int min_idx = q.peek().index; //extracting min index at each level
            int first = 0, last = 0;
            for(int i=0 ; i<s ; i++){
                TreeNode node = q.peek().node;
                int node_idx = q.peek().index - min_idx; //computing new index for node
                q.poll();
                if(node.left != null){
                    q.offer(new Pair(node.left, node_idx*2+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, node_idx*2+2));
                }

                if(i == 0) first = node_idx; //computing index of first node of the level
                if(i == s-1) last = node_idx; //computing index of last node of the level
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}
