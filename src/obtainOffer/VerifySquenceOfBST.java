package obtainOffer;

/**
 * 二叉搜索树的后序遍历
 *
 * 输入一个整数数组，判断这个数组是不是某二叉树的后序遍历结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数不相等。
 * 例如，输入数组{5，7，6，9，11，10，8}，则返回true，因为整个数序列是图4.9二叉搜索树的后序遍历结果。
 * 如果输入的数组是{7，4，6，5}，则由于没有那颗二叉搜索树的后序遍历结果是这个序列，因此返回false。
 */

public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] sequence1 = new int[] {5,7,6,9,11,10,8};
        int[] sequence2 = new int[] {7,4,6,5};

        boolean res = verifySquenceOfBST(sequence2, 0, sequence2.length-1);
        System.out.println(res);
    }

    public static boolean verifySquenceOfBST(int[] sequence,int begin,  int end) {

        if (sequence == null || end <= 0) return false;

        // 边界条件 当begin == end的时候 说明只剩下两个节点 说明遍历结果为正确的顺序 返回true
        if (begin == end) return true;

        // 最后一个数 为二叉搜索树的头节点
        int root = sequence[end];

        // 在二叉搜索树中 左子树节点的值小于根节点的值
        int i = begin;
        for (;i<end;i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 在二叉搜索树中右子节点的值大于根节点的值
        int j = i;
        for(; j< end;j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树是不是二叉树
        boolean left = true;
        // 递归左边的部分
        if (i-1>0) {
            left = verifySquenceOfBST(sequence,begin, i-1);
        }

        // 判断右子树是不是二叉搜索树
        boolean right = true;

        // 递归右边的部分
        if (i < end) {
            right = verifySquenceOfBST(sequence, i,end -1);
        }

        return (left && right);
    }

}
