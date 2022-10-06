package headfirstjava.chapter17;

public class GenerifiedPrinter<T> {
    T root;

    GenerifiedPrinter(T root){
        this.root = root;
    }

    public void print(T message) {
        System.out.println(root + " " + message);
    }
}
