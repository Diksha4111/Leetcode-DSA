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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ansList = new ArrayList<String>();
        findPath(root, "", ansList);
        return ansList;
    }
    public void findPath(TreeNode root, String str, List<String> list){
        if(root == null) return;
        if(isLeaf(root)){
            list.add(str + root.val);
        }
        str += root.val + "->";
        findPath(root.left , str, list);
        findPath(root.right , str, list);
    }
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
