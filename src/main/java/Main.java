public class Main {

    public static void main(String[] args) {
        Integer a = 1234567;
        Integer b = new Integer(a);
        Integer c = null;
        System.out.println("a == b :" + (a==b));
        System.out.println("a == 1234567:" + (a==1234567));
        System.out.println("b == 1234567 :" + (b==1234567));
        System.out.println("c == 1234567 :" + (c==1234567));
    }
}
