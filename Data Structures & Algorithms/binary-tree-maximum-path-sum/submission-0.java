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
    int maxPath = 0;
    public int maxSumdfs(TreeNode root){
        if(root==null) return 0;
        int lSum = maxSumdfs(root.left);
        int rSum = maxSumdfs(root.right);
        int currMaxPath = lSum+rSum+root.val;
        maxPath = Math.max(maxPath, currMaxPath);
        return Math.max(0,Math.max(lSum+root.val, rSum+root.val));
    }
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxSumdfs(root);
        return maxPath;
    }
}
