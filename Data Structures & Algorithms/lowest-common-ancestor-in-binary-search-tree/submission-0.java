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
//  */
//                                                 5
//                                     3                       8
//                             1              4            7        9
//                                 2               
// p=7, q=8
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) return lowestCommonAncestor(root, q, p);
        if(root.val>q.val) return lowestCommonAncestor(root.left, p,q);
        if(root.val<p.val) return lowestCommonAncestor(root.right, p,q);
        // root.val<= q.val && root.val>=p.val
        return root;
    }
}
