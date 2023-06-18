/*    TC = o(H)  H = Height of BST
      SC = o(1)   */

class Solution{
  main(TreeNode root , TreeNode x){
    TreeNode successor = null;
    while(root != null){
      if(x.val >= root.val){
        root = root.right;
      }
      else{
        successor = root;
        root = root.left;
      }
    }
    return successor;
  }
}
