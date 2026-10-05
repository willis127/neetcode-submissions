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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> treeList1= new LinkedList<>();
        List<Integer> treeList2= new LinkedList<>();
        treeToList(p, treeList1);
        treeToList(q, treeList2);
        if (treeList1.size() != treeList2.size())
            return false;
        for (int i = 0 ; i < treeList1.size() ; i++) {
            if (treeList1.get(i) != treeList2.get(i)) 
                return false;
        }
        return true;
    }
    private void treeToList(TreeNode in, List<Integer> list) {
        list.add(in != null ? in.val : null);
        if (in == null)
            return;
        treeToList(in.left, list);
        treeToList(in.right, list);
    }
}
