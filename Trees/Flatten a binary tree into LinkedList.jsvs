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

/* Recursive Approach 
      TC = O(N)  
      SC = O(N)  

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root != null) createLL(root);
    }
    private void createLL(TreeNode root) {
        if (root.right != null) createLL(root.right);
        if (root.left != null) createLL(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
} */

/* Iterative Approach
     TC = o(N)
     SC = O(N) 

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            st.pop();
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
} */


/* Morris Traversal 
     TC = O(N)
     SC = O(1)      */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
