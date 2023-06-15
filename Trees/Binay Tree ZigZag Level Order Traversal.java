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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode node = root;
        if(node ==  null) return ans;
        q.offer(node);
        boolean isReversed = true;  //for reversing the tempList alternatively
        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(int i=0 ; i<s ; i++){
                node = q.poll();
                tempList.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(!isReversed){
                Collections.reverse(tempList);
            }
            ans.add(tempList);
            isReversed = !isReversed; //to toggle true and false value of isReversed
        }
        return ans;
    }
}
