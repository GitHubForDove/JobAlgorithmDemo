import DataStruct.ListNode;
import leetCodePractise.ReverseKGroup;
import leetCodePractise.ReverseLinkedList;

public class NormalUseCodeBlock {






    /**
     *  0/1 背包问题
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static int knapsack(int[] weight, int[] value,int totalWeight) {
        // 前k个物品
        int k = weight.length;
        // 还有多少空间
        int w = totalWeight;

        int[][] B = new int[k][w+1];

        for (int i=1; i< k; i++) {
            for (int c=1; c < w+1; c++) {
                if (weight[i] > c) {
                    B[i][c] = B[i-1][c];
                } else {
                    B[i][c] = Math.max(B[i][c-weight[i]] + value[i], B[i-1][c]);
                }
            }
        }
        return B[k-1][w];
    }


    /**
     * 大数相加 将数变为字符串 然后每个位置进行相乘
     * @param num1
     * @param num2
     * @return
     */
    public static String muliply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int[] d = new int[num1.length() + num2.length()];

        for (int i=0; i< num1.length(); i++) {
            int a = num1.charAt(i) -'0';
            for (int j=0; j < num2.length();j++) {

                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }

        for (int k=0 ; k < d.length; k++) {
            int dight = d[k] % 10;
            int carry = d[k] / 10;
            sb.insert(0, dight);
            if (k < d.length-1 ) {
                d[k+1] += carry;
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }


    /**
     * 找出 第一个出现字串的位置
     * @param haystack
     * @param needle
     * @return
     */
    public static  int strStr(String haystack, String needle) {

        if (haystack.length() ==0 && needle.length() == 0) return 0;
        if (haystack.length() != 0 && needle.length() == 0) return 0;
        if ((haystack.length()==0 && needle.length() != 0) || haystack.length() < needle.length()) return -1;

        int index=0;
        boolean isInclude = false;

        for (int i=0; i<haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) break;
                int temp = i;

                for (int j=0; j< needle.length(); j++) {

                    if ( haystack.charAt(temp) != needle.charAt(j)) {
                        isInclude = false;
                        break;
                    }
                    temp++;
                    isInclude = true;
                }

                if (isInclude == true) {
                    index = i;
                    break;
                }
            }
        }
        return isInclude ? index : -1;
    }

    /**
     * 最长回文字串
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        // 使用数组下标进行记录
        int[] ans = new int[265];

        for (char c : s.toCharArray()) {
            ans[c] ++;
        }

        int length = 0;
        for (int a : ans) {
            length += (a / 2) * 2;
        }

        if (length < s.length()) {
            length = length +1;
        }

        return length;
    }



    /**
     * 反转链表
     *
     */
    public static ListNode ReverseList(ListNode pHead) {

        ListNode pReverseHead = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;

            if (pNext == null) pReverseHead = pNode;

            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    /**
     * 合并已经排好序的链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode mergeList(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null) return pHead2;
        else if (pHead2 == null) return pHead1;

        ListNode mergeListHead = null;

        /*if ((Integer)pHead1.value > (Integer)pHead2.value) {
            mergeListHead = pHead2;
            mergeListHead.next = mergeList(pHead1, pHead2.next);
        }else {
            mergeListHead = pHead1;
            mergeListHead.next = mergeList(pHead1.next, pHead2);
        }*/

        return mergeListHead;
    }



    /**
     * 找出路径
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row=0; row< rows; row++) {
            for (int col=0; col<cols; col++) {
                if (hasPathCore(matrix, rows,cols,row,col,str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 找到路径
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param str
     * @param pathLength
     * @param visited
     * @return
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                       char[] str, int pathLength, boolean[] visited) {

        if (pathLength == str.length) return true;

        boolean hasPath = false;

        if (row >=0 && row< rows && col>= 0 && col<cols &&
                matrix[row * cols + col] == str[pathLength] &&
                !visited[row* cols + col]) {
            // 路径加一
            ++pathLength;
            // 路径设为true
            visited[row*cols + col] = true;
            hasPath = hasPathCore(matrix, rows,cols, row+1,col,str,pathLength, visited)||
                    hasPathCore(matrix, rows,cols, row-1,col,str,pathLength, visited) ||
                    hasPathCore(matrix, rows,cols, row,col+1,str,pathLength, visited)||
                    hasPathCore(matrix, rows,cols, row,col-1,str,pathLength, visited);

            // 如果不是要找的路径 就返回 并visited[row * cols + col] 设置为false  表示为当前路径不对
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 递归进行反转链表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;

        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }

            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup2(next,k);
            }

            // prev 为链表翻转后的头结点
            return prev;

        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }


    /**
     * 创建链表
     * @param arr
     * @param n
     * @return
     */
    public static ListNode createLinkedList(int[] arr, int n) {
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;

        for (int i=1;i<n;i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLinkedList(ListNode head) {

        ListNode curNode = head;
        if (curNode == null) return;

        while (head!=null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
        return;
    }

}
