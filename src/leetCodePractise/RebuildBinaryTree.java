package leetCodePractise;


import Tree.TreeNode;

/**
 * 根据 二叉树的 前序遍历和 中序遍历 重建 二叉树 并 输出后序遍历
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        int[] newPreorder = new int[3];
       // System.arraycopy(preorder, 1,newPreorder,0,3);
        TreeNode root = constructCore(preorder, inorder);
        //root.lastShow();
        //System.out.println(Arrays.toString(newPreorder));
    }

    public static TreeNode construct(int[] preorder, int[] inorder) {

        return constructCore(preorder,  inorder);

    }

    /**
     * 重建树 中心算法
     * @return
     */
    public static TreeNode constructCore(int[] startPreorder, int[] inoder) {
        int len = startPreorder.length;
        int rootValue = startPreorder[0];
        TreeNode root = new TreeNode(rootValue);
        //root.leftNode = root.rightNode = null;
        int i=0;
        if (startPreorder == null && inoder == null && startPreorder.length <0 && inoder.length < 0) return null;

        while (len > 0) {
            if (inoder[i] == rootValue){
                break;
            }
            len --;
            i++;
        }
        int leftLen = i;
        int[] newPreorder = new int[i];
        int[] newInorder = new int[i];

        if (leftLen > 0) {

            // 构建左子树
            System.arraycopy(startPreorder, 1,newPreorder, 0,i);
            System.arraycopy(inoder, 0,newInorder, 0,i);
            //root.leftNode = constructCore(newPreorder, inoder);
        }
        if (startPreorder.length - i > 0 ) {
            // 构建左子树
            System.arraycopy(startPreorder, i+1,new int[startPreorder.length-i], 0,startPreorder.length-i-1);
            System.arraycopy(inoder, i+1,new int[startPreorder.length-i], 0,startPreorder.length-i-1);
            //root.rightNode = constructCore(newPreorder, inoder);
        }
        return root;

    }


}
