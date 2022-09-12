package headfirstjava.chapter12;

public class PantException extends Exception {
    @Override
    public String getMessage() {
        return "This is pant exception";
    }
}
