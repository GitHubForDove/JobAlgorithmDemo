package Bytedance;

import java.util.*;

public class Question_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] b = new int[26];
        int[] d = new int[26];
        for (int i=0;i<26;i++) {
            b[i] = sc.nextInt();
        }
        System.out.println();
        for (int j=0;j<26;j++) {
            d[j] = sc.nextInt();
        }
        game(b,d);


    }

    public static void game(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();

        List<Integer> Byte = new ArrayList<>();
        List<Integer> Dance = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<a.length; i++) {
            // 栈为空的情况
            if (stack.isEmpty()) {
                stack.push(a[i]);
                map.put(a[i],1);
            } else {

                if (map.containsKey(a[i])) {
                    List<Integer> temp = win(stack, b[i]);
                    Iterator iterator = temp.iterator();
                    while (iterator.hasNext()) {
                        Byte.add((Integer) iterator.next());
                    }
                    map.remove(a[i]);
                } else {
                    stack.push(a[i]);
                }

            }


            if (stack.isEmpty()) {
                stack.push(b[i]);
                map.put(b[i],1);
            } else {

                if (map.containsKey(b[i])) {
                    List<Integer> temp = win(stack, b[i]);
                    Iterator iterator = temp.iterator();
                    while (iterator.hasNext()) {
                        Dance.add((Integer) iterator.next());
                    }
                    map.remove(b[i]);
                } else {
                    stack.push(b[i]);
                }

            }

        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        if (Byte.size() > Dance.size()) {
            System.out.println("Byte");
        } else if (Byte.size() < Dance.size()) {
            System.out.println("Dance");
        } else {
            System.out.println("Draw");
        }

    }

    public static List<Integer> win(Stack<Integer> s, int val) {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        while (!s.empty()) {

            if (s.peek() != val) {
                int num = s.pop();
                list.add(num);
            }else {
                list.add(val);
                break;
            }

        }
        return list;
    }






}
