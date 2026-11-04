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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.offer(root);
        while(q.size()>0){
            Queue<TreeNode> temp = new LinkedList<>();
            int first=0;
            while(q.size()>0){
                TreeNode t = q.poll();
                if(first==0) ans.add(t.val);
                if(t.right!=null) temp.offer(t.right);
                if(t.left!=null) temp.offer(t.left);
                first=1;
            }
            q=temp;
        }
        return ans;
    }
}
