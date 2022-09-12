package headfirstjava.chapter10;

public class Duck {
    public int size;

    public Duck(int duckSize){
        size = duckSize;
        System.out.println("Duck of size " + size + " has been created");
    }

    public Duck(){
        size = 27;
        System.out.println("Duck of size " + size + " has been created");
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }
}
