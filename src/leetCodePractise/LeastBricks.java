package leetCodePractise;


import java.util.*;

/**
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。

 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。

 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。

 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 */
public class LeastBricks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> wall = new ArrayList<>();
        while (true) {

            String lists = sc.nextLine();
            if (lists.length() == 0 || lists == null) break;
            String s = lists.trim().replace(",", "");
            char[] c = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<c.length; i++) {
                list.add(c[i] - '0');
            }
            wall.add(list);
        }

        /*Iterator it = wall.listIterator();

        while (it.hasNext()) {

            System.out.println(it.next());
        }*/
        int res = leastBricks(wall);
        System.out.println(res);
    }

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();   // <砖块长度，出现次数>键值表
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) { // 记录每一行中能形成的砖块长度（除0和砖墙宽度外）
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max= 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            max = value > max ? value : max; // 获得最大出现次数
        }
        return wall.size() - max;      // 砖墙高度-最大出现次数
    }
}
