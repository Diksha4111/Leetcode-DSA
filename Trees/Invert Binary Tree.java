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
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            //swapping left and right nodes of root node
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //recursively swapping left and right nodes of left sub-tree
            invertTree(root.left);
            //recursively swapping left and right nodes of right sub-tree 
            invertTree(root.right);
        }
        return root;
    }
}
