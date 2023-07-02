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



// class Solution {
//     public String tree2str(TreeNode root) {
//         return helper(root);
//     }
//     public String helper(TreeNode root){
//         if(root == null) return "";
//         if(root.left == null && root.right == null){
//             return root.val + "";
//         }
//         if(root.right == null){
//             return root.val + "(" + helper(root.left) + ")";
//         }
//         return root.val + "(" + helper(root.left) + ")(" + helper(root.right) + ")";
//     }
// }



class Solution{
    String str = "";
    public String tree2str(TreeNode root){
        helper(root);
        return str;
    }
    public void helper(TreeNode root){
        if(root == null) return;

        str += String.valueOf(root.val);

        //if leaf node is reached then to avoid extra parantheses we return back from there.
        if(root.left == null && root.right == null) return;
        
        str += "(";
        helper(root.left);
        str += ")";
        if(root.right != null){
            str += "(" ;
            helper(root.right);
            str += ")";
        }
    }
}
