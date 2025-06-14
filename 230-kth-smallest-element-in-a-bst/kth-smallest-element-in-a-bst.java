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

 // 1.traverse bst and add nodes to prioriy queue of size k
 // 2.return priority queue

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
         helper(root,k);
        return pq.peek();
    }

    private void helper(TreeNode root, int k){
        if(root == null) return;
        pq.add(root.val);
        while(pq.size() > k) pq.poll();
        helper(root.left,k);
        helper(root.right,k);
    }
}