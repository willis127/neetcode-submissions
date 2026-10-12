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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> route1 = new LinkedList<>();
        List<TreeNode> route2 = new LinkedList<>();
        findRoute(root, p.val, route1);
        findRoute(root, q.val, route2);
        TreeNode latestCommon = null;
        for (int i = 0 ; i < Math.min(route1.size(), route2.size()) ; i++) {
            if (route1.get(route1.size() - 1 - i).val == route2.get(route2.size() - 1 - i).val) {
                latestCommon = route1.get(route1.size() - 1 - i);
            } else {
                break;
            }
        }
        return latestCommon;
    }
    private boolean findRoute(TreeNode node, int target, List<TreeNode> list) {
        if (node == null)
            return false;
        if (node.val != target) {
            if (findRoute(node.left, target, list) || findRoute(node.right, target, list)) {
                list.add(node);
                return true;
            } else {
                return false;
            }
        } else {
            if (node.val == target) {
                list.add(node);
                return true;
            } else {
                return false;
            }
        }
    }
}
