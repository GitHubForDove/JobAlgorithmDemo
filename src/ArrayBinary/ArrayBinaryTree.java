package ArrayBinary;

public class ArrayBinaryTree {

    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(int index) {
        if (data == null && data.length == 0) {
            return;
        }

        System.out.println(data[index]);
        // 2*index+1:处理左子树
        if (2*index+1 < data.length) {
            frontShow(2*index+1);
        }

        // 2*n+2: 处理右子树
        if (2*index+2 < data.length) {
            frontShow(2*index+2);
        }
    }

    public void midShow(int index) {
        if (2*index+1 < data.length) {
            midShow(2*index+1);
        }
        System.out.println(data[index]);

        if (2*index+2 < data.length) {
            midShow(2*index+2);
        }
    }

    public void afterShow(int index) {
        if (2*index+1 < data.length) {
            afterShow(2*index+1);
        }

        if (2*index+2 < data.length) {
            afterShow(2*index+2);
        }
        System.out.println(data[index]);

    }
}
