package obtainOffer;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-14
 * @descript 二叉搜索书转化为一个排序的双向链表
 */
public class ConvertBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        TreeNode head = convert(root);

        System.out.println(head.val);

        while (head.right != null) {
            System.out.println(head.right.val);
            head = head.right;
        }

        while (head.left != null) {
            System.out.println(head.left.val);
            head = head.left;
        }
    }

    public static TreeNode convert(TreeNode root) {
        TreeNode lastNode = null;

        TreeNode head = convert2Link(root, lastNode);
        while (head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }

    public static TreeNode convert2Link(TreeNode rootTree, TreeNode lastNode) {
        if (rootTree == null) {
            return null;
        }
        if (rootTree.left != null) {
            lastNode = convert2Link(rootTree.left, lastNode);
        }
        rootTree.left = lastNode;
        if (lastNode != null) {
            lastNode.right = rootTree;
        }
        lastNode = rootTree;
        if (rootTree.right != null) {
            lastNode = convert2Link(rootTree.right, lastNode);
        }
        return lastNode;
    }

}