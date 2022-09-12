package headfirstjava.chapter8;

public class Overloads {
    String uniqueId;


    // These setters are overloaded
    public void setUniqueId(String id) {
        this.uniqueId = id;
    }

    public void setUniqueId(int id) {
        this.uniqueId = Integer.toString(id);
    }



    // These methods are overloaded
    public int addNumbers(int a, int b){
        return a + b;
    }

    public double addNumbers(double a, double b){
        return a + b;
    }
}
