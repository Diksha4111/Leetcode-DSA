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

//Time complexity: O(H) , which can be approx. O(N) in case of skewed trees.
//Space complexity: Approach 1 - O(H) , Approach 2 - O(1)

/* APPROACH 1 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Stack<Integer> st = new Stack<Integer>();
        helper(root , st, 0);
        int ans = st.pop();
        return ans;     
    }
    public void helper(TreeNode root, Stack<Integer> st, int level){
        if(root == null) return;

        if(level == st.size()){
            st.push(root.val);
        }
        helper(root.left , st, level+1);
        helper(root.right , st, level+1);
    }
} 

/* APPROACH 2 */
class Solution {
    int bottomLeftValue = 0, maxLevel = Integer.MIN_VALUE ;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return bottomLeftValue;     
    }
    public void helper(TreeNode root, int level){
        if(root == null) return;

        //finding element at the last level 
        if(level > maxLevel){
            bottomLeftValue = root.val;
            maxLevel = level;
        }

        //recursively traversing left and right sub-tree to find value at the last level
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
} 
