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


/* O(N) approach  
class Solution {
    int ans = 0;
    public int countNodes(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null) return 0; 

        ans += 1;
        helper(root.left);
        helper(root.right);

        return ans;
    }
}*/


/* O(logN x logN) = O(logN^2) approach */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        //calculate left ans right sub-tree height
        int lH = leftHeight(root);
        int rH = rightHeight(root);

        //if the two heights are same then return (2^h) - 1
        if(lH == rH) return ((2<<(lH))-1);

        //if the two heights are not same then recursively calculate heights of left and 
        //right sub-trees of left and right node of the parent node and 
        //add 1 after you get the two heights 
        return countNodes(root.left) + countNodes(root.right) + 1;

    }
    //method to calculate left sub-tree height
    public int leftHeight(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    //method to calculate right sub-tree height
    public int rightHeight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}
