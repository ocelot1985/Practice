package com.demo;

import java.util.ArrayList;
import java.util.List;

// 提示
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//Find the total sum of all root-to-leaf numbers.
//The tree is given in an int array, in which -1 means null node.  “-1” items may be omitted only when they are the last items in the array.



//For example:
//Input1: [1,2,6,3,-1,-1, -1, 4, 5]
//Input2: [1,2,6,3,-1,-1, -1, 4, 5,-1,-1]
//The above two input represent the same tree below:
//           1
//       2     6
//    3
//4    5
//The root-to-leaf paths of this tree are 1234, 1235, 16
//so the output should be 2485

public class SumPathOfBinaryTree {
	
	private List<String> pathStrList = new ArrayList<String>();

	
	/**
	 * 深度优先遍历二叉树
	 * @return
	 */
	public void traverse(String baseData, int[] treeData, int curInd) {
		int length = treeData.length;
		int leftLeafInd = (int) (2*curInd + 1);
		int rightLeafInd = (int) (2*curInd + 2);
		boolean leftLeafNull = leftLeafInd >= length || treeData[leftLeafInd] == -1;
		boolean rightLeafNull = rightLeafInd >= length || treeData[rightLeafInd] == -1;
		StringBuilder pathStr = new StringBuilder();
		// 拼接path的数字序列为字符串
		String curPathStr = pathStr.append(baseData).append(String.valueOf(treeData[curInd])).toString();
		if ((leftLeafNull && rightLeafNull) || curInd >= length) {
			// 空节点或到达处理完成
			// 注意排查2个叶子节点为空的情况,会产生重复
			if ((leftLeafNull && rightLeafNull) ) {
				pathStrList.add(curPathStr);
			}
			return;
		}
		
		// 递归处理左子树,右子树
		if (!leftLeafNull) {
			traverse(curPathStr, treeData, leftLeafInd);
		}
		if (!rightLeafNull) {
			traverse(curPathStr, treeData, rightLeafInd);
		}
		return;
	}
	
	/**
	 * 处理demo的主入口
	 * @param treeData
	 * @return
	 */
	public int demo(int[] treeData) {
		Integer sum = 0;
		// 遍历处理
		this.traverse("", treeData, 0);
		// 加和备选列表的path代表的数值结果
		for (String item : this.pathStrList) {
			// 转换为整型
			Integer pathVal = Integer.parseInt(item);
			sum += pathVal;
		}
		return sum.intValue();
	}
	
	public static void main(String[] args) {
		// 测试数据
		int[] data1 = {1,2,6,3,-1,-1, -1, 4, 5};
		
		SumPathOfBinaryTree demo = new SumPathOfBinaryTree();
		int sumPath = demo.demo(data1);
		System.out.println(sumPath);
	}
}
