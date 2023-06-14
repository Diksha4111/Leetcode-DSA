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
    public List<Integer> postorderTraversal(TreeNode root) {

        /* 2 stack approach */
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }
        return ans;

    
        /* 1 stack approach */
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>():
        TreeNode curr = root;
        TreeNode temp;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
            st.push(curr);
            curr = curr.left;
        } 
        else{
            temp = st.top().right;
            if(temp != null){
                curr = temp;
            }
            else{
                temp = st.pop();
                ans.add(temp.val);
                while(!st.isEmpty() && temp == st.top().right){
                    temp = st.pop();
                    ans.add(temp.val);
                }
            }
        }
        }
        return ans;
    }
}


/* Recursive approach
    void postorder(node){
        if(node == null){
            return ;
        }
        postorder(node.left);
        postorder(node.right);
        print(node.val);
    }
*/
