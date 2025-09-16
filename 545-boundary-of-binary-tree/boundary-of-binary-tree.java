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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        //Tc - O(H) + O(H) + O(N) = O(N), Sc - O(H) (recursive stack)

        //1. first add root and then all the left boundary except leaves - if root.left == null then add right
        //2. add the leave nodes
        //3. add the right nodes in reversal - if root.right == null then add left

        List<Integer> result = new ArrayList<>();
        if(!isLeaf(root)){
            result.add(root.val);
        }
        addLeftBoundary(root,result);
        addLeafNodes(root,result);
        addRightBoundary(root,result);

        return result;    
    }

    public boolean isLeaf(TreeNode root){

        return root.left == null &&  root.right == null;
    }

    public void addLeafNodes(TreeNode root, List<Integer> result){

        if(isLeaf(root)){
            result.add(root.val);
            return;
        }

        if(root.left != null) addLeafNodes(root.left,result);
        if(root.right != null) addLeafNodes(root.right,result);
    }

    public void addLeftBoundary(TreeNode root, List<Integer> result){
        TreeNode curr = root.left;

        while(curr != null){
            if(!isLeaf(curr)){
                result.add(curr.val);
            }
                if(curr.left!= null){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
            
        }

        
    }

    public void addRightBoundary(TreeNode root, List<Integer> result){
        TreeNode curr = root.right;

        List<Integer> list = new ArrayList<>();

        while(curr != null){
                if(!isLeaf(curr)){
                    list.add(curr.val);
                }
                if(curr.right!= null){
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            
        }

        for(int i = list.size() - 1; i>= 0; i--){
            result.add(list.get(i));
        }
    }
}