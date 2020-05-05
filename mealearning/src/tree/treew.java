package tree;

import java.util.HashMap;

import java.util.HashSet;

import java.util.LinkedHashSet;

import java.util.Iterator;

public class treew {

	public static void main(String[] args) {

		// 输入数据集1

		String deData[][] = new String[13][];

		deData[0] = new String[] { "Yes", "No", "No", "Yes", "Some", "high",
				"No", "Yes", "French", "0~10", "Yes" };

		deData[1] = new String[] { "Yes", "No", "No", "Yes", "Full", "low",
				"No", "No", "Thai", "30~60", "No" };

		deData[2] = new String[] { "No", "Yes", "No", "No", "Some", "low",
				"No", "No", "Burger", "0~10", "Yes" };

		deData[3] = new String[] { "Yes", "No", "Yes", "Yes", "Full", "low",
				"Yes", "No", "Thai", "10~30", "Yes" };

		deData[4] = new String[] { "Yes", "No", "Yes", "No", "Full", "high",
				"No", "Yes", "French", ">60", "No" };

		deData[5] = new String[] { "No", "Yes", "No", "Yes", "Some", "middle",
				"Yes", "Yes", "Italian", "0~10", "Yes" };

		deData[6] = new String[] { "No", "Yes", "No", "No", "None", "low",
				"Yes", "No", "Burger", "0~10", "No" };

		deData[7] = new String[] { "No", "No", "No", "Yes", "Some", "middle",
				"Yes", "Yes", "Thai", "0~10", "Yes" };

		deData[8] = new String[] { "No", "Yes", "Yes", "No", "Full", "low",
				"Yes", "No", "Burger", ">60", "No" };

		deData[9] = new String[] { "Yes", "Yes", "Yes", "Yes", "Full", "high",
				"No", "Yes", "Italian", "10~30", "No" };

		deData[10] = new String[] { "No", "No", "No", "No", "None", "low",
				"No", "No", "Thai", "0~10", "No" };

		deData[11] = new String[] { "Yes", "Yes", "Yes", "Yes", "Full", "low",
				"No", "No", "Burger", "30~60", "Yes" };
		
		deData[12] = new String[] { "Yes", "Yes", "Yes", "Yes", "Full", "low",
				"No", "No", "Burger", "30~60", "No" };
		

		// 待分类的属性集1

		String attr[] = new String[] { "alt", "bar", "fri", "hun", "pat",
				"price", "rain", "res", "type", "est" };
		
		LinkedHashSet<String> attributes = new LinkedHashSet<String>();

		for (int i = 0; i < attr.length; i++) {
			attributes.add(attr[i]);
		}

		// 属性与数据集中对应数据的下标

		HashMap<String, Integer> attrIndexMap = new HashMap<String, Integer>();

		for (int i = 0; i < attr.length; i++) {
			attrIndexMap.put(attr[i], i);
		}

		// 需要分类的数据，初始为整个数据集
		boolean flags[] = new boolean[deData.length];
		for (int i = 0; i < deData.length; i++) {
			flags[i] = true;
		}

		// 构造决策树

		TreeNode root = new TreeNode();

		DecisionTree decisionTree = new DecisionTree(root);

		decisionTree.buildDecisionTree(root, deData, flags, attributes,
				attrIndexMap);

	}

}
