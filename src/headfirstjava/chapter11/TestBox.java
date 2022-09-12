package headfirstjava.chapter11;

public class TestBox {
    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox tb = new TestBox();
        tb.go();
    }

    public void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }


}
