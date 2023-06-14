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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] m = new int[1];
        findMaxDiameter(root,m);
        return m[0];
    }
    int findMaxDiameter(TreeNode root , int[] maxm){
        if(root == null){
            return 0;
        }

        int lh = findMaxDiameter(root.left,maxm);
        int rh = findMaxDiameter(root.right,maxm);

        maxm[0] = Math.max(maxm[0], lh+rh);

        return 1+Math.max(lh,rh);
    }
}
