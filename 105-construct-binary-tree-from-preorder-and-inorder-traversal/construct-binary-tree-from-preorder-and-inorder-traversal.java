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
    //1. create a hashmap and store all the inorder values
    //2. find the root from preorder and then split the inorder list.
    //3. build the new tree from the preorder and inorder
    //4. return root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return treeBuild(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    private TreeNode treeBuild(int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd,Map<Integer,Integer> map){

        if(inStart > inEnd || preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        //findng where the root is in the inorder list
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        //now build left and right trees

        root.left = treeBuild(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);

        root.right = treeBuild(preorder,preStart+1+numsLeft,preEnd,inorder,inRoot+1,inEnd,map);

        return root;

    }
}