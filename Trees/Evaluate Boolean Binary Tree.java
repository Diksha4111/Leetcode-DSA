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
    public boolean evaluateTree(TreeNode root) {
        //if leaf node and has value 0 then returhn false else return 1
        if(root.left == null && root.right == null){
            if(root.val == 0) return false;
            else return true;
        }
        //if non-leaf node and has value 2 then return OR between its left and right nodes
        if(root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);

        //else return AND between node's left and right nodes
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
