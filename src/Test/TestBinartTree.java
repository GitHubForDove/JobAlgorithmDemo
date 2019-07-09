package Test;

import Tree.BinaryTree;
import Tree.TreeNode;

public class TestBinartTree {

    public static void main(String[] args) {
        // 创建一颗树
        BinaryTree binTree = new BinaryTree();
        // 创建根节点
        TreeNode root = new TreeNode(1);
        // 树添加根节点
        binTree.setRoot(root);
        // 创建新右节点
        TreeNode rootR = new TreeNode(3);
        // 创建新左节点
        TreeNode rootL = new TreeNode(2);

        // 根节点设置左儿子
        root.setlNode(rootL);
        // 根节点设置右儿子
        root.setrNode(rootR);

        rootL.setrNode(new TreeNode(5));
        rootL.setlNode(new TreeNode(4));

        rootR.setrNode(new TreeNode(7));
        rootR.setlNode(new TreeNode(6));

        // 前序遍历
        binTree.frontShow();

        System.out.println("--------------------------------");

        // 中序遍历
        binTree.midShow();

        System.out.println("--------------------------------");

        // 后序遍历
        binTree.afterShow();

        // 前序遍历
        TreeNode result = binTree.frontSearch(3);

        System.out.println("--------------------------------");

        System.out.println(result == rootR);

        System.out.println("--------------------------------");

        binTree.delete(5);
        System.out.println(rootL==null);
        binTree.frontShow();
    }


}
