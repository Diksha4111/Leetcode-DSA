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
    int maxm = 0;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {

        postorder(root);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == maxm){
                ans.add(i);
            }
        }

        int[] result = new int[ans.size()];
        for(int i=0 ; i<ans.size() ; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
    public int postorder(TreeNode root){
        if(root == null) return 0;

        int left = postorder(root.left);
        int right =postorder(root.right);
        int sum = left + right + root.val;

        map.put(sum , map.getOrDefault(sum , 0) + 1);
        maxm = Math.max(maxm , map.get(sum));

        return sum;
    }
}
