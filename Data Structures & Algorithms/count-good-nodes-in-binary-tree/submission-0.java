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
//                                             2,-1
//                                     1,2                 1,2
//                             3,2                   1,2           5,2
// 1+1+1 = 3


class Solution {
    int totGood= 0;
    public void good(TreeNode root, int currMaxVal){
        if(root==null) return;
        if(root.val>=currMaxVal) totGood++;
        good(root.left, Math.max(currMaxVal, root.val));
        good(root.right, Math.max(currMaxVal, root.val));
    }
    public int goodNodes(TreeNode root) {
        totGood=0;
        good(root, Integer.MIN_VALUE);
        return totGood;
    }
}
