package leetcode.prac;

//给定一个二叉树，找出其最小深度。
//
//        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        给定二叉树 [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回它的最小深度  2.

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfTree {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<Bag> queue = new LinkedList<Bag>();
        Bag rootBag = new Bag();
        rootBag.node = root;
        rootBag.level = 1;
        queue.offer(rootBag);
        Bag cur = null;
        while ((cur = queue.poll()) != null) {
            TreeNode node = cur.node;
            if (node.left == null && node.right == null) {
                return cur.level;
            }
            if (node.left != null) {
                Bag bag = new Bag();
                bag.node = node.left;
                bag.level = cur.level + 1;
                queue.offer(bag);
            }
            if (node.right != null) {
                Bag bag = new Bag();
                bag.node = node.right;
                bag.level = cur.level + 1;
                queue.offer(bag);
            }
        }
        return 0;
    }

    public class Bag {
        TreeNode node;
        int level;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
