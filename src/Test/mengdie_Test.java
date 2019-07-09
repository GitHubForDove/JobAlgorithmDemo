package Test;

public class mengdie_Test {

    static {
        A = "ab";
        B = "cd";
    }

    private final static String A ;
    private final static String B ;

    private final static String C = "ab" ;
    private final static String D = "cd";



    public static void main(String[] args) {

        String t = A+B;
        String m = "abcd";

        String n = C+D;
        String k = "abcd";

        if (t == m) {
            System.out.println("t==m");
        } else {
            System.out.println("t!=m");
        }

        if (n == k) {
            System.out.println("n==k");
        } else {
            System.out.println("n!=k");
        }

    }
}
