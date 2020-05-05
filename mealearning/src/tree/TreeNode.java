package tree;

import java.util.HashMap;

import java.util.HashSet;

import java.util.LinkedHashSet;

import java.util.Iterator;

//1、selectAtrribute中的一个数组下标出错 2、两个字符串相等的判断

//3、输入的数据有一个错误 4、selectAtrribute中最后一个循环忘记了i++

//决策树的树结点类

public class TreeNode {

	String element; // 该值为数据的属性名称

	String value; // 上一个分裂属性在此结点的值

	LinkedHashSet<TreeNode> childs; // 结点的子结点，以有顺序的链式哈希集存储

	public TreeNode() {

		this.element = null;

		this.value = null;

		this.childs = null;

	}

	public TreeNode(String value) {

		this.element = null;

		this.value = value;

		this.childs = null;

	}

	public String getElement() {

		return this.element;

	}

	public void setElement(String e) {

		this.element = e;

	}

	public String getValue() {

		return this.value;

	}

	public void setValue(String v) {

		this.value = v;

	}

	public LinkedHashSet<TreeNode> getChilds() {

		return this.childs;

	}

	public void setChilds(LinkedHashSet<TreeNode> childs) {

		this.childs = childs;

	}

}