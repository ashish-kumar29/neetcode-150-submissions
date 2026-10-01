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
                                    //                 2,2
                                    //     1,1                       3,3



                                    //                 4,3
                                    //         3,2               5,4
                                    // 2,1



                                    //                 4,3
                                    //         2,2               5
                                    // 1,1           3,3

class Solution {
    int favAns=0;
    public int setOrder(TreeNode root, int prevOrder, int k){
        if(root==null) return 0;
        int leftSubOrder = setOrder(root.left, prevOrder,k);
        int currOrder = leftSubOrder+prevOrder+1;
        if(currOrder==k) favAns = root.val;
        int finalOrderSub = setOrder(root.right, currOrder, k);
        return Math.max(currOrder, finalOrderSub);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans = setOrder(root, 0, k);
        return favAns;
    }
}
