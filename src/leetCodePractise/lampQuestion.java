package leetCodePractise;


import java.util.Scanner;

/**
 * 题目描述
 *
 * 城市E的马路上有很多路灯，每两个相邻路灯之间的间隔都是1公里。小赛是城市E的领导，为了使E城市更快更好的发展，
 * 需要在城市E的一段长度为M的主干道上的一些区域建地铁。这些区域要是建了地铁，就需要挪走相应的路灯。
 * 可以把长度为M的主干道看成一个数轴，一端在数轴0的位置，另一端在M的位置；数轴上的每个整数点都有一个路灯。
 * 要建地铁的这些区域可以用它们在数轴上的起始点和终止点表示，已知任一区域的起始点和终止点的坐标都是整数，
 * 区域之间可能有重合的部分。现在要把这些区域中的路灯（包括区域端点处的两个路灯）移走。你能帮助小赛计算一下，
 * 将这些路灯移走后，马路上还有多少路灯？
 */
public class lampQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n  = sc.nextInt();
            int m  = sc.nextInt();
            int[][] s = new int[m][2];
            for (int i=0; i<m;i++) {
                s[i][0] = sc.nextInt();
                s[i][1] = sc.nextInt();
            }
            //float res = ratio(str);
            //int res = lamp(n, s);

            System.out.println(s.length);
        }
    }

    public static int lamp(int n, int[][] s) {

        for(int i=0; i<s.length; i++) {


        }

        return 0;
    }


}
