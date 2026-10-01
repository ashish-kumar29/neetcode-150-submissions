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

                                //             5
                                // 4                       6
                                //       7          3               7
                                            
                                            
                                            
                                //             4(-101,101)
                                // 2(-101,4)                       9(4,101)
                                //                     7(4,9)            12
                                //             4,7            8(7,9)
                                            
                                            
                                            
                                //             5
                                // 4                       6
                                //       7          3               7

                                        //         1(-1001, 1001)
                                        // 2               3
class Solution {
    public boolean isValid(TreeNode root, int lRange, int rRange){
        if(root==null) return true;
        if(root.val>=rRange || root.val<=lRange) return false;
        return isValid(root.left, lRange, root.val) && isValid(root.right, root.val, rRange);

    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, -1001, 1001);
    }
}
