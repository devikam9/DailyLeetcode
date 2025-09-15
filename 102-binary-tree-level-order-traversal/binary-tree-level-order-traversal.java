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
    public List<List<Integer>> levelOrder(TreeNode root) {

        //Tc - O(N), Sc - O(N)

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        
        Queue<TreeNode> que = new LinkedList<>();
        
        que.add(root);

        while(!que.isEmpty()){

            int level = que.size();    
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < level; i++){
                TreeNode node = que.remove();
                list.add(node.val);
                if(node.left != null){
                    que.add(node.left);
                }if(node.right != null){
                    que.add(node.right);
                }
                
            }
            result.add(list);    
        }
        return result;    
    }
}