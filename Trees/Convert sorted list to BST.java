/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int count = 0;

        //calculating linkedlist length
        ListNode temp = new ListNode();
        temp = head;
        while(temp.next != null){
            count++;
            temp = temp.next;
        } 

        return helper(head , 0 , count);
    }
    public TreeNode helper(ListNode head , int low , int high){
        //base condition for recursion to stop
        if(low > high) return null;

        //calculating mid element in the linkedList
        int mid = (low+high) / 2;
        ListNode curr = new ListNode();
        curr = head;
        int count = 0;
        while(count != mid){
            count++;
            curr = curr.next;
        }

        //creating node of the previously found mid element
        TreeNode root = new TreeNode(curr.val);

        //recursively creating left ans right sub-tree of each node
        root.left = helper(head , low , mid-1);
        root.right = helper(head , mid+1 , high);

        return root;
    }
}
