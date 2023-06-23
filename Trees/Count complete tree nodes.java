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
class Solution {
    int ans = 0;
    public int countNodes(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root == null) return 0; 
      
        //adding 1 each time we reach a node
        ans += 1;

        //recursively traversing left and right sub-tree of each node 
        helper(root.left);
        helper(root.right);

        return ans;
    }
}
