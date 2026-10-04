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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode p = root;
        TreeNode tmp = null;
        if (p.left != null || p.right != null) {
            tmp = p.right;
            p.right = p.left;
            p.left = tmp;
            if (p.left != null)
                invertTree(p.left);
            if (p.right != null)
                invertTree(p.right);
        }
        return root;
    }
}
