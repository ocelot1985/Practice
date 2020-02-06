import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树具有n个节点,每个节点有0个或大于0个硬币,并且整棵树拥有的硬币数总和为n.
 * 求将硬币均衡散列到所有节点,并且保证每个节点在获取到1个硬币的操作均为最少操作.
 * 
 * 例如,
 *   (3)
 *   / \
 * (0) (0)   的最优操作数总和为2
 * 
 *   (0)
 *   / \
 * (0) (3)   的最优操作数总和为3
 * 
 *   (2)
 *   / \
 * (1) (0)   的最优操作数总和为1
 * 
 * 
 * @author cephas.zhang
 *
 */
public class SplitCoinInBiTree {
	
	public List<Integer> opList = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		SplitCoinInBiTree demo = new SplitCoinInBiTree();
		demo.doit();
		demo.doit2();
		demo.doit3();
	}
	
	public void doit() {
		opList.clear();
		Node left = new Node();
		Node right = new Node();
		left.coin = 0;
		right.coin = 3;
		Node parent = new Node();
		parent.coin = 0;
		parent.left = left;
		parent.right = right;
		
		demo(parent);
		int sum = 0;
		for (Integer item : opList) {
			System.out.println("item:" + item);
			sum += item;
		}
		System.out.println("sum:" + sum);
	}
	
	public void doit2() {
		opList.clear();
		Node left = new Node();
		Node right = new Node();
		left.coin = 1;
		right.coin = 0;
		Node parent = new Node();
		parent.coin = 2;
		parent.left = left;
		parent.right = right;
		
		demo(parent);
		int sum = 0;
		for (Integer item : opList) {
			System.out.println("item:" + item);
			sum += item;
		}
		System.out.println("sum:" + sum);
	}
	
	public void doit3() {
		opList.clear();
		Node left = new Node();
		Node right = new Node();
		left.coin = 0;
		right.coin = 0;
		Node parent = new Node();
		parent.coin = 3;
		parent.left = left;
		parent.right = right;
		
		demo(parent);
		int sum = 0;
		for (Integer item : opList) {
			System.out.println("item:" + item);
			sum += item;
		}
		System.out.println("sum:" + sum);
	}
	
	public int[] demo(Node node) {
		int[] leftCoinArr = null;
		int[] rightCoinArr = null;
		// 0元素:当前节点欠多少coin
		// 1元素:当前接单有多少多余coin
		int[] coinArr = new int[2];
		if (null != node.left) {
			leftCoinArr = demo(node.left);
		}
		if (null != node.right) {
			rightCoinArr = demo(node.right);
		}
		// 当前为叶子节点场景
		if (null == node.left && null == node.right) {
			if (node.coin >= 1) {
				coinArr[0] = 0;
				coinArr[1] = node.coin - 1;
			} else {
				coinArr[0] = 1;
				coinArr[1] = 0;
			}
		} else {
			int balance = (node.coin + leftCoinArr[1] + rightCoinArr[1]) - (1 + leftCoinArr[0] + rightCoinArr[0]);
			if (balance > 0) {
				coinArr[0] = 0;
				coinArr[1] = balance;
			} else {
				coinArr[0] = balance;
				coinArr[1] = 0;
			}
		}
		opList.add(coinArr[0]);
		opList.add(coinArr[1]);
		return coinArr;
	}

	
	public class Node {
		public Node left;
		public Node right;
		
		public int coin;
	}
}
