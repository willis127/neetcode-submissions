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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> nextDeque = new ArrayDeque<>();
        if (root == null) return result;
        deque.add(root);
        while (true) {
            if (deque.isEmpty())
                break;
            List<Integer> intListThisLevel = new LinkedList<>();
            for (TreeNode node : deque) {
                intListThisLevel.add(node.val);
                if (node.left != null) {
                    nextDeque.add(node.left);
                }
                if (node.right != null) {
                    nextDeque.add(node.right);
                }
            }
            deque.clear();
            for (TreeNode node : nextDeque)
                deque.add(node);
            nextDeque.clear();
            result.add(intListThisLevel);
        }
        return result;
    }
}
