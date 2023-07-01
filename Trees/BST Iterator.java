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
class BSTIterator {
    List<Integer> ans;
    int next = 0;

    public BSTIterator(TreeNode root) {
        this.ans = new ArrayList<>(); 
        inorder(root);
    }
    
    public int next() {
        return ans.get(next++);
    }
    
    public boolean hasNext() {
        if(ans.size() > next) return true;

        return false;
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
