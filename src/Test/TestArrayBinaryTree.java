package Test;

import ArrayBinary.ArrayBinaryTree;

public class TestArrayBinaryTree {

    public static void main(String[] args) {
        int[] data = new int[] {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(data);
        abt.frontShow(0); // 从第一个位置进行先序遍历
        System.out.println(" ---------------------  ");
        abt.midShow(0); // 中序遍历
        System.out.println(" ---------------------  ");
        abt.afterShow(0); // 后序遍历
    }
}
