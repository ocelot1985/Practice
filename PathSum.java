package leetcode.prac;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例: 
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \      \
//        7    2      1
//        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。


public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        return hasSum(root, sum, 0);
    }

    public boolean hasSum(TreeNode node, int sum, int curSum) {
        if (node.left == null && node.right == null) {
            if (curSum + node.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        boolean leftResult = false, rightResult = false;
        if (node.left != null) {
            leftResult = hasSum(node.left, sum, curSum + node.val);
        }
        if (node.right != null) {
            rightResult = hasSum(node.right, sum, curSum + node.val);
        }
        return leftResult || rightResult;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
