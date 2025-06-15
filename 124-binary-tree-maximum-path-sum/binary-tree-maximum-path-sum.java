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

 //From every node calculate the right and left path
 // return whichever is maximum
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

         helper(root);
        return max;
    }

    private int helper(TreeNode root){

        if(root == null) return 0;
        // to handle negative paths ans, keep max(0,calling function ans)
        int lh =  Math.max(0,helper(root.left));//-1
        int rh =  Math.max(0,helper(root.right));

        max = Math.max(max,lh+rh+root.val);

        return root.val + Math.max(lh,rh);
    }
}