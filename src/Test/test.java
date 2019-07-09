package Test;

public class test {

    public static void main(String[] args) {

        int exp = 13;
        int len = 10;
        while ( len > 0) {
            System.out.println("exp : " +exp + " :" +  (exp & 0x1));
            System.out.println(exp);
            exp = exp >> 1;
            len --;
        }
    }
}
