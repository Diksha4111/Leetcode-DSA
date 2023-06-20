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
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left , root.right);
    }
    public boolean checkSymmetric(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null) return true; //if both sub-trees are null
        if(root1 == null || root2 == null) return false; //if one of the sub-trees are null

        //checking recursively that is the left ans right sub-tree are symmetric or not.
        //Symmetric means -> left of left sub-tree will be eqaul(similar) to right of right sub-tree and right of left sub-tree will be equal to left of right sub-tree.
        return ((root1.val == root2.val) && checkSymmetric(root1.left , root2.right) && checkSymmetric(root1.right , root2.left));
    }
}
