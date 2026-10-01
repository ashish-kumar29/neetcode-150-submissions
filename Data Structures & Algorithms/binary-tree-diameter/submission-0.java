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

                            //       1
                            //      2 
                            //    4    5
                            //   6  7     9
                            //  8 
class Solution {
    int maxDiameter = 0;
    public int depth(TreeNode root){
        if(root==null) return 0;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        maxDiameter = Math.max(maxDiameter, lDepth+rDepth);
        return 1+Math.max(lDepth, rDepth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter=0;
        depth(root);
        return maxDiameter;
    }
}
