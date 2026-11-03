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
        Queue<TreeNode> level = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        level.add(root);
        while(level.size()>0){
            Queue<TreeNode> level1 = new LinkedList<>();
            List<Integer> tmp=new ArrayList<>();
            while(level.size()>0){
                TreeNode node = level.poll();
                tmp.add(node.val);
                if(node.left!=null) level1.add(node.left);
                if(node.right!=null) level1.add(node.right);
            }
            level = level1;
            ans.add(tmp);
        }
        return ans;
    }
}