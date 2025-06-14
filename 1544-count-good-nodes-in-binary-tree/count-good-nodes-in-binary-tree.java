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

 //1.store root value
 //2. go left - check if lh >  currnode in left : update lh and return 0
 //3. else - update lh = currNode and then return 1
 //4. same for right
 // reaches null then u return count
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
         helper(root.val,root); 
        return count;   
    }


    private int helper(int max, TreeNode root){

        if(root == null) return 0;
        
        if(root.val >= max){
            max = root.val; 
            count++; 
        }

        helper(max,root.left);
        helper(max,root.right);

        
        return 1;
    }
}