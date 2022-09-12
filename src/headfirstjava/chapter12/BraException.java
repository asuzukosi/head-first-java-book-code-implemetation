package headfirstjava.chapter12;

public class BraException extends Exception {
    @Override
    public String getMessage() {
        return "Tis a bra exception";
    }
}
