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

                                                    //     1
                                                    // 2       3
                                                    //      4
                                                    //  5

class Solution {
    public int bDepth(TreeNode root){
        if(root==null) return 0;
        int lDepth = bDepth(root.left);
        int rDepth = bDepth(root.right);
        if(lDepth<0 || rDepth<0) return -1;
        if(Math.abs(lDepth-rDepth)>1) return -1;
        return 1+Math.max(lDepth, rDepth);
    }
    public boolean isBalanced(TreeNode root) {
        int ans = bDepth(root);
        return ans!=-1;
    }
}
