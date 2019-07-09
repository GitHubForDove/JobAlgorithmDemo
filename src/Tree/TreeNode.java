package Tree;



public class TreeNode {

    // 节点的权
    public int value;

    // 左儿子
    public TreeNode lNode;

    //右儿子
    public TreeNode rNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setlNode(TreeNode lNode) {
        this.lNode = lNode;
    }


    public void setrNode(TreeNode rNode) {
        this.rNode = rNode;
    }

    // 前序遍历
    public void frontShow() {
        // 先遍历当前节点的内容
        System.out.println(value);
        if (lNode != null) {
            lNode.frontShow();
        }

        // 右节点
        if (rNode != null) {
            rNode.frontShow();
        }
    }

    // 中序遍历
    public void midShow() {
        // 左节点
        if (lNode != null) {
            lNode.midShow();
        }

        // 当前节点
        System.out.println(value);

        // 右节点
        if (rNode != null) {
            rNode.midShow();
        }
    }

    public void afterShow() {

        if (lNode != null) {
            lNode.afterShow();
        }

        if (rNode != null) {
            rNode.afterShow();
        }

        System.out.println(value);
    }


    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        if (this.value == i) {
            return this;
        } else {

            if (lNode != null){
                // 有可能可以查到，也可以查不到，查不到的话，target还是一个null
                target = lNode.frontSearch(i);
            }

            // 如果不为空，说明在左儿子中已经找到
            if (target != null) {
                return target;
            }

            if (rNode != null) {
                target = rNode.frontSearch(i);
            }
        }
        return target;
    }

    public void delete(int i) {
        TreeNode parent = this;
        //先查看左节点是否是查找的值
        if (parent.lNode != null && parent.lNode.value == i) {
            parent.lNode = null;
            return;
        }
        if (parent.rNode != null && parent.rNode.value == i) {
            parent.rNode = null;
            return;
        }

        //递归检查并删除左儿子
        parent = lNode;
        if (parent != null) {
            parent.delete(i);
        }

        // 递归检查并删除右儿子
        parent = rNode;
        if (parent != null){
            parent.delete(i);
        }
    }
}
