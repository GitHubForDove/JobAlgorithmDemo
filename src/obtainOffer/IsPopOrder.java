package obtainOffer;

import java.util.Stack;

/**
 *
 */
public class IsPopOrder {

    /**
     * 栈的压入、弹出序列是否正确
     */

    public static void main(String[] args) {
        int[] pPop = new int[]{4,3,5,1,2};
        int[] pPush = new int[]{1,2,3,4,5};
        boolean res = isPopOrder(pPush,pPop,5);
        System.out.println(res);
    }


    public static boolean isPopOrder(int[] pPush, int[] pPop, int nLength) {
        boolean bPossible = false;
        int pPushSize = 0;
        int pPopSize = 0;
        if (pPush != null && pPop != null && nLength > 0) {
            Stack<Integer> stack = new Stack();
            while (pPopSize < nLength) {
                // 当栈为空与栈顶元素与pPop[pPopSize]不相等时 进行
                while (stack.empty() || stack.peek() != pPop[pPopSize]) {

                    if (pPushSize >= nLength) {
                        break;
                    }
                    stack.push(pPush[pPushSize++]);
                }

                // 如果不相等 直接弹出
                if (stack.peek() != pPop[pPopSize]) {
                    break;
                }

                stack.pop();
                pPopSize++;
            }

            if (stack.empty() && pPopSize == nLength) {
                bPossible = true;
            }

        }
        return bPossible;
    }

}
