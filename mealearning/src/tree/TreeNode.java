package tree;

import java.util.HashMap;

import java.util.HashSet;

import java.util.LinkedHashSet;

import java.util.Iterator;

//1��selectAtrribute�е�һ�������±���� 2�������ַ�����ȵ��ж�

//3�������������һ������ 4��selectAtrribute�����һ��ѭ��������i++

//���������������

public class TreeNode {

	String element; // ��ֵΪ���ݵ���������

	String value; // ��һ�����������ڴ˽���ֵ

	LinkedHashSet<TreeNode> childs; // �����ӽ�㣬����˳�����ʽ��ϣ���洢

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