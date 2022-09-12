package headfirstjava.chapter12;

public class BadException extends Exception {
    @Override
    public String getMessage() {
        return "E be things";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
